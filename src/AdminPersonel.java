import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AdminPersonel extends Person {
    AdminPersonel(String FirstName, String LastName, String Status, String Username, String Password) {
        super(FirstName, LastName, Status, Username, Password);
    }

    public static void addPerson() {
        String x;
        String NewFirst, NewLast, NewStatus, NewUsername, NewPassword;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter FirstName");
        NewFirst = scanner.nextLine();
        System.out.println("Enter LastName");
        NewLast = scanner.nextLine();
        while (true) {
            System.out.println("Enter Position: ");
            NewStatus = scanner.nextLine();
            NewStatus = NewStatus.toLowerCase();
            if (NewStatus.equals("admin") || NewStatus.equals("cashier")) {
                break;
            } else {
                System.out.println("No such position");
            }
        }
        while (true) {
            Boolean flag = false;
            System.out.println("Enter Username");
            NewUsername = scanner.nextLine();
            String regex = "^[a-zA-Z0-9_]+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(NewUsername);
            if (matcher.matches()) {
                Iterator<Person> iterator = PersonelList.iterator();
                Person currentPersonel = null;
                while (iterator.hasNext()) {
                    currentPersonel = iterator.next();
                    if(NewUsername.equals(currentPersonel.getUsername()))
                    {
                        flag = true;
                    }


                }
                if (flag) {
                    System.out.println("Username Already Exist");
                } else {
                    break;
                }
            } else {
                System.out.println("Input contains non-alphanumeric characters.");
            }
        }

        System.out.println("Enter Password");
        NewPassword = scanner.nextLine();

        while (true) {
            System.out.println("Are you sure you want to add this Personel y/n");
            x = scanner.nextLine();
            x = x.toLowerCase();
            if (x.equals("y") || x.equals("n")) {
                break;
            } else {
                System.out.println("not a valid choice");
            }
        }


        if(x.equals("y"))

    {
        addPersonel(NewFirst, NewLast, NewStatus, NewUsername, NewPassword);
        savePersonData();
        System.out.println("Personel Has been added");
    }
        if(x.equals("n"))

    {
        System.out.println("Personnel has not been added");
    }
}


    public static void deletePersonel() {
        Scanner scanner = new Scanner(System.in);
        showIPersonel();
        String z ;
        while (true) {
            System.out.println("Enter the Username you want to delete");
            String x = scanner.nextLine();

            // Check if x is alphanumeric using a regular expression
            if (x.matches("^[a-zA-Z0-9]+$")) {
                Iterator <Person> iterator = PersonelList.iterator();
                Person currentPerson = null;
                while(iterator.hasNext()){
                    currentPerson = iterator.next();

                    if(x.equals(currentPerson.getUsername()))
                    {
                        System.out.println("Product FirstName " + currentPerson.getFirstName());
                        System.out.println("Product LasName " + currentPerson.getLastName());
                        System.out.println("Product Position " + currentPerson.getStatus());
                        System.out.println("Product username "  + currentPerson.getUsername());
                        System.out.println("Product Password "  + currentPerson.getPassword());
                        while(true) {
                            System.out.println("Are you sure you want to delete the data? y/n: ");
                            z = scanner.nextLine();
                            z = z.toLowerCase();
                            if(z.equals("y") || z.equals("n")){
                                break;
                            }
                            else {
                                System.out.println("Not a Valid choice");
                            }
                        }
                        if(z.equals("y"))
                        {
                            iterator.remove();
                            System.out.println("Personel deleted.");
                            savePersonData();
                            break;
                        }
                        if (z.equals("n"))
                        {
                            System.out.println("Personel not deleted.");
                            break;

                        }
                        else{
                            System.out.println("input not valid");
                        }
                    }
                    if (!iterator.hasNext()){
                        System.out.println("Username "+ x + " not found");
                        break;
                    }
                }
                break;

            } else {
                System.out.println("Not alphanumeric. Please enter an alphanumeric value.");
            }
        }
    }

    public static void updatePersonel() {
        Scanner scanner = new Scanner(System.in);
        showIPersonel();
        String z ;
        while (true) {
            System.out.println("Enter the Username you want to delete");
            String x = scanner.nextLine();

            // Check if x is alphanumeric using a regular expression
            if (x.matches("^[a-zA-Z0-9]+$")) {
                Iterator <Person> iterator = PersonelList.iterator();
                Person currentPerson = null;
                while(iterator.hasNext()){
                    currentPerson = iterator.next();

                    if(x.equals(currentPerson.getUsername()))
                    {
                        System.out.println("Product FirstName " + currentPerson.getFirstName());
                        System.out.println("Product LasName " + currentPerson.getLastName());
                        System.out.println("Product Position " + currentPerson.getStatus());
                        System.out.println("Product username "  + currentPerson.getUsername());
                        System.out.println("Product Password "  + currentPerson.getPassword());
                        while(true) {
                            System.out.println("Are you sure you want to update the data? y/n: ");
                            z = scanner.nextLine();
                            z = z.toLowerCase();
                            if(z.equals("y") || z.equals("n")){
                                break;
                            }
                            else {
                                System.out.println("Not a Valid choice");
                            }
                        }
                        if(z.equals("y"))
                        {
                            String NewFirst, NewLast, NewStatus, NewUsername, NewPassword;
                            System.out.println("Enter FirstName");
                            NewFirst = scanner.nextLine();
                            System.out.println("Enter LastName");
                            NewLast = scanner.nextLine();
                            while (true) {
                                System.out.println("Enter Position: ");
                                NewStatus = scanner.nextLine();
                                NewStatus = NewStatus.toLowerCase();
                                if (NewStatus.equals("admin") || NewStatus.equals("cashier")) {
                                    break;
                                } else {
                                    System.out.println("No such position");
                                }
                            }
                            while (true) {
                                Boolean flag = false;
                                System.out.println("Enter Username");
                                NewUsername = scanner.nextLine();
                                String regex = "^[a-zA-Z0-9_]+$";
                                Pattern pattern = Pattern.compile(regex);
                                Matcher matcher = pattern.matcher(NewUsername);
                                if (matcher.matches()) {
                                    Iterator <Person> iterator1 = PersonelList.iterator();
                                    Person currentPersonel = null;
                                    while (iterator1.hasNext()) {
                                        currentPersonel = iterator1.next();

                                        if(NewUsername.equals(currentPerson.getUsername()))
                                        {
                                            flag = false;

                                        }
                                        else if(NewUsername.equals(currentPersonel.getUsername()))
                                        {
                                            flag = true;
                                            break;
                                        }


                                    }
                                    if (flag) {
                                        System.out.println("Username Already Exist");
                                    } else {
                                        break;
                                    }
                                } else {
                                    System.out.println("Input contains non-alphanumeric characters.");
                                }
                            }

                            System.out.println("Enter Password");
                            NewPassword = scanner.nextLine();
                            currentPerson.setFirstName(NewFirst);
                            currentPerson.setLastName(NewLast);
                            currentPerson.setStatus(NewStatus);
                            currentPerson.setUsername(NewUsername);
                            currentPerson.setPassword(NewPassword);
                            System.out.println("Personel updated.");
                            savePersonData();
                            break;
                        }
                        if (z.equals("n"))
                        {
                            System.out.println("Personel not updated.");
                            break;

                        }
                        else{
                            System.out.println("input not valid");
                        }
                    }
                }
                break;

            } else {
                System.out.println("Not alphanumeric. Please enter an alphanumeric value.");
            }
        }
    }
}

