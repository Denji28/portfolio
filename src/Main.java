import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;



public class Main {
    public static void main(String[] args) {

        String username,password;
        Item.loadItem();
        Person.loadPersonel();
        Scanner scanner = new Scanner(System.in);
        int c = 0;
        int c2 = 0;
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
                    System.out.println("Input contains non-alphanumeric characters.");
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
                       Cashier.paymentProcess();
                       break;
                   case 3:
                       break;
                   default:
                       System.out.println("not in the choices");
                       break;
               }
           }
       }

        if(Person.getContainer_stat().equals("admin"))
        {
            while(c!=3)
            {
                System.out.println("[1] Item Menu");
                System.out.println("[2] Personel Menu");
                System.out.println("[3] Go Back");
                System.out.print("Enter choice: ");
                c = scanner.nextInt();
                scanner.nextLine();
                switch(c){
                    case 1:
                        System.out.println("[1] Add new Iteam");
                        System.out.println("[2] Display Items");
                        System.out.println("[3] Delete Item");
                        System.out.println("[4] Update Item");
                        System.out.println("[5] Display Purchase History");
                        c2 = scanner.nextInt();

                        switch(c2)
                        {
                            case 1:
                                AdminItems.storeItem();
                                break;
                            case 2:
                                Item.showItem();
                                break;
                            case 3:
                                System.out.println("[1] Delete one item");
                                System.out.println("[2] Delete all Item");
                                int c3 = scanner.nextInt();
                                if(c3 == 1)
                                {
                                    AdminItems.deleteItem();
                                } else if (c3==2) {
                                    AdminItems.deleteAll();
                                }
                                else {
                                    System.out.println("not in the choices");
                                }

                                break;
                            case 4:
                                AdminItems.updateItem();
                                break;
                            case 5:
                                AdminItems.showHistory();
                                break;
                            default:
                                System.out.println("not in the choices");
                                break;

                        }
                        break;
                    case 2:
                        System.out.println("[1] Add Personel");
                        System.out.println("[2] Display Personel");
                        System.out.println("[3] Delete Personel");
                        System.out.println("[4] Update personel");
                        int c3 = scanner.nextInt();
                        switch(c3){
                            case 1:
                                AdminPersonel.addPerson();
                                break;
                            case 2:
                                Person.showIPersonel();
                                break;
                            case 3:
                                AdminPersonel.deletePersonel();
                                break;
                            case 4:
                                AdminPersonel.updatePersonel();
                                break;
                            default:
                                System.out.println("not in the choices");
                                break;
                        }
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Choice not valid");

                }
            }
        }




    }
}