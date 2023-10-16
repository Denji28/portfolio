import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Person {

    public String FirstName,LastName,Status,Username,Password;

    public static String Container_stat;
    public static Boolean Checker =  false;

    public static String getContainer_stat() {return Container_stat;}

    public static void setContainer_stat(String container_stat) {Person.Container_stat = container_stat;}

    public static Boolean getChecker(){return Checker;};

    public static void setChecker(Boolean checker) {Person.Checker = checker;}

    public String getFirstName() {return FirstName;}

    public void setFirstName(String firstName) {this.FirstName = firstName;}

    public String getLastName() {return LastName;}

    public void setLastName(String lastName) {this.LastName = lastName;}

    public String getStatus(){return Status;}

    public void setStatus(String status) {this.Status = status;}

    public String getUsername() {return Username;}

    public void setUsername(String username) {this.Username = username;}

    public String getPassword(){return Password;}

    public void setPassword(String password) {this.Password = password;}

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

}
