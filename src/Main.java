import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;



public class Main {
    public static void main(String[] args) {

        String username,password;
        Item.loadItem();
        Person.loadPersonel();
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            while(true)
            {
                System.out.print("Enter Username: ");
                username = scanner.nextLine();
                String regex = "^[a-zA-Z0-9_]+$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(username);
                if (matcher.matches()) {
                    break;
                } else {
                    System.out.println("Input contains non-alphanumeric characters or no underscores.");
                }
            }
            System.out.print("Enter Password: ");
            password = scanner.nextLine();
            Person.verification(username,password);


            if(Person.getChecker())
            {
                break;
            }
            else{
                System.out.println("No such User");
            }
        }

       if(Person.getContainer_stat().equals("cashier"))
       {
           int c = 0;
           while(c!=3)
           {
               System.out.println("Cashier Menu");
               System.out.println("[1] Add Item to Cart");
               System.out.println("[2] Process Payment");
               System.out.println("[3] Exit");
               System.out.print("Enter Choice: ");
               c = scanner.nextInt();

               switch (c)
               {
                   case 1:
                       Cashier.addToCart();
                       break;
                   case 2:
                       break;
                   case 3:
                       break;
                   default:
                       System.out.println("not in the choices");
                       break;
               }
           }
       }




    }
}