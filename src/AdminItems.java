import java.util.Iterator;
import java.util.LinkedList;
import java.util.Calendar;
import java.util.Scanner;

public class AdminItems extends Item {

    private static int GeneratedCode;

    private static int getGeneratedCode(){ return GeneratedCode;}
    private static void setGeneratedCode(int GeneratedCode){AdminItems.GeneratedCode = GeneratedCode;}

    AdminItems(int ProductId, String ProductName, int Quantity, double Price,int GeneratedCode) {

        super(ProductId, ProductName, Quantity, Price);
        AdminItems.GeneratedCode=GeneratedCode;
    }


    public static void storeItem(){
        Scanner scanner = new Scanner(System.in);
        String x;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        String code = String.format("%04d", 1); // Initialize with "0001"
        Iterator<Item> iterator = ItemList.iterator();
        Item currentItem = null;
        while (iterator.hasNext()) {
            currentItem = iterator.next();
            String SCode = currentYear + code;
            int generateCode = Integer.parseInt(SCode);
            if (currentItem.getProductId() == generateCode) {
                int codeNumber = Integer.parseInt(code);
                ++codeNumber; // Increment the code number
                code = String.format("%04d", codeNumber);

                // Check if we've generated all possible codes for the year
                if (code.equals("10000")) {
                    currentYear++; // Move to the next year
                    code = "0001"; // Reset the code to "0001" for the new year
                }

            }
                SCode = currentYear + code;
                generateCode = Integer.parseInt(SCode);
                int StoreCode = generateCode;
                setGeneratedCode(StoreCode);
        }
        System.out.print("Enter The name of the product: ");
        String NewName = scanner.nextLine();
        System.out.print("Enter Product Quantity: ");
        int NewQuantity = scanner.nextInt();
        System.out.print("Enter The product Price");
        double NewPrice = scanner.nextDouble();
        scanner.nextLine();
        while (true){
            System.out.println("Product Code: "+getGeneratedCode());
            System.out.println("Product Name: "+NewName);
            System.out.println("Product Quantity: "+NewQuantity);
            System.out.println("Product Price: "+ NewPrice);
            System.out.print("Do you want to add y/n? ");
            x = scanner.nextLine();
            x = x.toLowerCase();
            if (x.equals("y")||x.equals("n"))
            {
                break;
            }
            else{
                System.out.println("Invalid choice");
            }
        }

        if (x.equals("y"))
        {
            addItem(getGeneratedCode(),NewName,NewQuantity,NewPrice);
            saveItemData();
        }
        else {
            System.out.println("Product not save");
        }
    }

    public static void deleteItem(){
        Scanner scanner = new Scanner(System.in);
        showItem();
        while(true) {
            System.out.println("Enter the ProductId you want to delete");
             String x = scanner.nextLine();
            try {
                String z;
                // Attempt to parse the input as an integer
                int intValue = Integer.parseInt(x);
                Iterator <Item> iterator = ItemList.iterator();
                Item currentItem = null;
                while(iterator.hasNext()){
                    currentItem = iterator.next();

                    if(currentItem.getProductId() == intValue)
                    {
                        System.out.println("ProductId: " + currentItem.getProductId());
                        System.out.println("ProductName: " + currentItem.getProductName());
                        System.out.println("Quantity: " + currentItem.getQuantity());
                        System.out.println("Price: " + "PHP " + currentItem.getPrice());
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
                                System.out.println("Product deleted.");
                                saveItemData();
                                break;
                            }
                            if (z.equals("n"))
                            {
                                System.out.println("Product not deleted.");
                                break;

                            }
                            else{
                                System.out.println("input not valid");
                            }
                        }
                    if (!iterator.hasNext()){
                        System.out.println("ProductId"+ intValue + "not found");
                    }
                }


                break; // Exit the loop if it's a valid integer
            } catch (NumberFormatException e) {
                System.out.println("Not an integer. Please enter an integer.");
            }

        }
    }

    public static void deleteAll(){
        String x;
        while(true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Are you sure you want to delele all the item? y/n");
            x = scanner.nextLine();
            x = x.toLowerCase();
            if(x.equals("y") || x.equals("n"))
            {
                break;
            }
            else{
                System.out.println("not a valid choice");
            }
        }

        if (x.equals("y"))
        {
            ItemList.clear();
        }
    }
}
