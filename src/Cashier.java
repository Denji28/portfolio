import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedWriter;
public class Cashier extends Item {

    private static double Amount= 0 ,TotalDiscount = 0;
    private static double DiscountPercent = 0.20;

    Cashier(String ProductName, int ProductId, int Quantity, double Price) {
        super( ProductId,ProductName, Quantity, Price);
    }

    public  static double getAmount() {  return Amount; }
    public static void setAmount(double Amount){Cashier.Amount = Amount;};


    public static double getTotalDiscount() {  return Cashier.TotalDiscount; }
    public static void setTotalDiscount(double TotalDiscount){Cashier.TotalDiscount = TotalDiscount; };

    public static double getDiscountPercent() {  return Cashier.DiscountPercent; }
    public static void setDiscountPercent(double DiscountPercent){Cashier.DiscountPercent = DiscountPercent; };
    private static LinkedList<Item> CartList = new LinkedList<>();


    public static void showCart()
    {
        if(ItemList.isEmpty())
        {
            System.out.println("no Item to display");
        }
        else {
            for (int i = 0; i < CartList.size(); i++) {
                System.out.println("Product Name " + CartList.get(i).getProductName());
                System.out.println("Product Quantity " + CartList.get(i).getQuantity());
                System.out.println("Product Price " + "PHP " + CartList.get(i).getPrice());
            }
        }

    }

    public static void addToCart()
    {
        double ProductAmount = 0.0;
        Scanner scanner = new Scanner(System.in);
        Item.showItem();


        int parsedCode = 0, parsedQuantity = 0; // Initialize to a default value (0 in this case)

        boolean validInput = false;
        boolean productExists = false;

        while(true)
        {

                System.out.print("Enter the code of the Product: ");
                String code = scanner.nextLine();
                System.out.print("Enter Desired Quantity: ");
                String quantity = scanner.nextLine();

                try {
                    parsedCode = Integer.parseInt(code);
                    parsedQuantity = Integer.parseInt(quantity);
                    validInput = true; // Input is valid, exit the loop
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Both code and quantity should be integers.");
                    continue;
                }
               Iterator<Item> iterator = ItemList.iterator();
                Item currentItem = null;
            while (iterator.hasNext()) {
                currentItem = iterator.next();

                if (currentItem.getProductId() == parsedCode) {
                    productExists = true;

                    if (currentItem.getQuantity() >= parsedQuantity) {
                        ProductAmount = parsedQuantity * currentItem.getPrice();
                        Item item = new Item(currentItem.getProductId(), currentItem.getProductName(), parsedQuantity, ProductAmount);
                        CartList.add(item);
                        currentItem.setQuantity(currentItem.getQuantity() - parsedQuantity);
                        Cashier.setAmount(getAmount()+ProductAmount);
                        break; // Exit the loop after adding the item to the cart
                    } else {
                        System.out.println("Not enough stock for product with code " + parsedCode);
                    }
                }
            }

            if (productExists) {
               break;
            }
            else {
                System.out.println("Product with code " + parsedCode + " does not exist.");
            }

        }

    }

    public static void paymentProcess()
    {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Create a DateTimeFormatter to format the output (optional)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Format and print the current date and time
        String formattedDateTime = currentDateTime.format(formatter);

        double payment = 0;
        double change = 0;
        int CardNum = 0;
        int Cvc = 0;
        String y = "";
            Scanner scanner = new Scanner(System.in);
            Cashier.showCart();
            System.out.println("Total Price: " + getAmount());
            System.out.println("Choose payment method");
            System.out.println("[1] Cash");
            System.out.println("[2] Bank payment");
            System.out.println("Enter Choice: ");
            int c = scanner.nextInt();

            scanner.nextLine();

            switch(c)
            {
                case 1:

                    while(true) {
                        System.out.println("Are you Senior Citizen, Student, Member y/n");
                        System.out.println("Enter Choice: ");
                        String x = scanner.nextLine();
                        x = x.toLowerCase();
                        y = x;
                        if(x.equals("y")||x.equals("n")) {
                            break;
                        }
                        else {
                            System.out.println("not a valid choice");
                        }
                    }
                    if(y.equals("y"))
                    {
                        setTotalDiscount(getAmount()*getDiscountPercent());
                        setAmount(getAmount()-getTotalDiscount());
                        Cashier.showCart();
                        System.out.println("Total Discount: "+"php "+getTotalDiscount());
                        System.out.println("Total Price: "+"php "+getAmount());
                        while(true) {
                            System.out.println("Enter cash payment: ");
                            payment = scanner.nextDouble();
                            if (payment>=getAmount())
                            {

                                change = payment - getAmount();
                                System.out.println(change);

                                break;
                            }
                            System.out.println("Payment not enough");
                        }

                    }
                    else {
                        Cashier.showCart();
                        System.out.println("Total Discount: "+"php "+getTotalDiscount());
                        System.out.println("Total Price: "+"php "+getAmount());
                        while(true) {
                            System.out.println("Enter cash payment: ");
                            payment = scanner.nextDouble();
                            if (payment>getAmount())
                            {
                                change = payment - getAmount();
                                System.out.println("Change: "+change);
                                break;
                            }
                            System.out.println("Payment not enough");
                        }
                    }
                    break;


                case 2:
                    System.out.println("Card payment");
                    while(true) {
                        System.out.println("Are you Senior Citizen, Student, Member y/n");
                        String x = scanner.nextLine();
                        x = x.toLowerCase();
                        y =x;
                        if(x.equals("y")||x.equals("n")) {
                            break;
                        }
                        System.out.println("not a valid choice");
                    }
                    if(y.equals("y"))
                    {
                        setTotalDiscount(getAmount()*getDiscountPercent());
                        setAmount(getAmount()-getTotalDiscount());
                        Cashier.showCart();
                        System.out.println("Total Discount: "+"php "+getTotalDiscount());
                        System.out.println("Total Price: "+"php "+getAmount());
                        while(true) {
                            System.out.println("Enter Card number: ");
                            CardNum = scanner.nextInt();
                            System.out.println("Enter CVC: ");
                            Cvc = scanner.nextInt();
                            String regex = "^[0-9]+$";
                            String CCardNum =  Integer.toString(CardNum);
                            String CCvc =  Integer.toString(Cvc);
                            Pattern pattern = Pattern.compile(regex);
                            Matcher matcher = pattern.matcher(CCardNum);
                            Matcher matcher2 = pattern.matcher(CCvc);
                            if (matcher.matches() && matcher2.matches()) {
                                System.out.println("Payment succesfull");
                                break;
                            } else {
                                System.out.println("Invalid input.");
                            }

                        }

                    }
                    else {
                        Cashier.showCart();
                        System.out.println("Total Discount: "+"php "+getTotalDiscount());
                        System.out.println("Total Price: "+"php "+getAmount());

                            while(true) {
                                System.out.println("Enter Card number: ");
                                CardNum = scanner.nextInt();
                                System.out.println("Enter CVC: ");
                                Cvc = scanner.nextInt();
                                String regex = "^[0-9]+$";
                                String CCardNum =  Integer.toString(CardNum);
                                String CCvc =  Integer.toString(Cvc);
                                Pattern pattern = Pattern.compile(regex);
                                Matcher matcher = pattern.matcher(CCardNum);
                                Matcher matcher2 = pattern.matcher(CCvc);
                                if (matcher.matches() && matcher2.matches()) {
                                    System.out.println("Payment succesfull");
                                    break;
                                } else {
                                    System.out.println("Invalid input.");
                                }

                            }

                    }
                    break;

            }


        // Specify the file path
        String filePath = "PurchaseHistory.txt";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true)); // Append to the file

            Iterator<Item> iterator = CartList.iterator();
            Item currentItem = null;
            while (iterator.hasNext()) {
                currentItem = iterator.next();
                writer.write("ProductName: " + currentItem.getProductName());
                writer.newLine();
                writer.write("ProductQuantity: " + currentItem.getQuantity());
                writer.newLine();
                writer.write("ProductPrice: " + currentItem.getPrice());
                writer.newLine();
            }
            writer.write("Total Amount: " + getAmount());
            writer.newLine();
            writer.write("Date&time: " + formattedDateTime);
            writer.newLine();
            writer.close(); // Close the writer to save the file
        } catch (IOException e) {
            e.printStackTrace();
        }


        setAmount(0);
        setTotalDiscount(0);
        CartList.clear();
        Item.saveItemData();

        }




}




