import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;


import java.io.File;


public class Person {

    protected String FirstName,LastName,Status,Username,Password;

    public static String Container_stat;
    public static Boolean Checker =  false;

    public static String getContainer_stat() {return Container_stat;}

    public static void setContainer_stat(String container_stat) {Person.Container_stat = container_stat;}

    public static Boolean getChecker(){return Checker;}

    public static void setChecker(Boolean checker) {Person.Checker = checker;}

    protected String getFirstName() {return FirstName;}

    protected void setFirstName(String firstName) {this.FirstName = firstName;}

    protected String getLastName() {return LastName;}

    protected void setLastName(String lastName) {this.LastName = lastName;}

    protected String getStatus(){return Status;}

    protected void setStatus(String status) {this.Status = status;}

    protected String getUsername() {return Username;}

    protected void setUsername(String username) {this.Username = username;}

    protected String getPassword(){return Password;}

    protected void setPassword(String password) {this.Password = password;}

    Person(String FirstName,String LastName,String Status,String Username,String Password)
    {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Status = Status;
        this.Username = Username;
        this.Password = Password;
    }
    protected static LinkedList<Person> PersonelList = new LinkedList<>();


    public static void addPersonel(String FirstName,String LastName,String Status,String Username,String Password)
    {
        Person person = new Person(FirstName,LastName,Status,Username,Password);
        PersonelList.add(person);
    }


    public static void loadPersonel()
    {
        try {
            File file = new File("personel_data.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Extract item data
                String[] parts = line.split(",");
                String FirstName = parts[0];
                String LastName = parts[1];
                String Status = parts[2];
                String Username = parts[3];
                String Password = parts[4];

                addPersonel(FirstName, LastName, Status, Username,Password);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open item data file for loading...");
        }
    }

    protected static void verification(String UserName,String Password)
    {
        Iterator<Person> iterator = PersonelList.iterator();
        Person currentPerson = null;
        while (iterator.hasNext()) {
            currentPerson = iterator.next();

            if (currentPerson.getUsername().equals(UserName) && currentPerson.getPassword().equals(Password) ) {
                setChecker(true);
                setContainer_stat(currentPerson.getStatus());
            }
        }
    }


    public static void savePersonData() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("personel_data.txt"));

            Iterator<Person> iterator = PersonelList.iterator();
            Person currentPerson = null;

            while (iterator.hasNext()) {
                currentPerson = iterator.next();
                // Write item data in a formatted manner
                writer.write(currentPerson.getFirstName() + "," + currentPerson.getLastName() + ","
                        + currentPerson.getStatus() + "," +currentPerson.getUsername()+","+currentPerson.getPassword());
                writer.newLine(); // Add a newline for each item
            }

            writer.close();
            System.out.println("Item data saved to personel_data.txt");
        } catch (IOException e) {
            System.err.println("Unable to open item data file for saving...");
            e.printStackTrace();
        }
    }

    public static void showIPersonel()
    {
        if(PersonelList.isEmpty())
        {
            System.out.println("no Item to display");
        }
        else {
            for (int i = 0; i < PersonelList.size(); i++) {
                System.out.println("Personel FirstName " + PersonelList.get(i).getFirstName());
                System.out.println("Personel LasName " + PersonelList.get(i).getLastName());
                System.out.println("Personel Position " + PersonelList.get(i).getStatus());
                System.out.println("Personel username "  + PersonelList.get(i).getUsername());
                System.out.println("Personel Password "  + PersonelList.get(i).getPassword());
            }
        }

    }

}
