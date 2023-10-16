import java.util.Scanner;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Iterator;
public class Cashier extends Item {

    private static double Amount= 0 ,TotalDiscount;
    private static double DiscountPercent = 0.20;

    Cashier(String ProductName, int ProductId, int Quantity, double Price) {
        super( ProductId,ProductName, Quantity, Price);
    }

    public  static double getAmount() {  return Amount; }
    public static void setAmount(double Amount){Cashier.Amount += Amount;};


    public static double getTotalDiscount() {  return TotalDiscount; }
    public static void setTotalDiscount(double TotalDiscount){TotalDiscount = TotalDiscount; };

    private static LinkedList<Item> CartList = new LinkedList<>();


    public static void showCart()
    {
        for (int i = 0; i < CartList.size(); i++) {
            System.out.println("Product ID " + CartList.get(i).getProductId());
            System.out.println("Product Name " + CartList.get(i).getProductName());
            System.out.println("Product Quantity " + CartList.get(i).getQuantity());
            System.out.println("Product ID " + "PHP " + CartList.get(i).getPrice());
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
//            while (!validInput) {
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
//            }

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
                        Cashier.setAmount(ProductAmount);
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



}




