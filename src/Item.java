import java.io.*;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Scanner;

public class Item {
    public  String ProductName;
    public  int ProductId,Quantity;
    public  double Price;

    public static LinkedList<Item> ItemList = new LinkedList<>();




    public String getProductName() {  return ProductName;}
    public void setProductName(String ProductName){this.ProductName = ProductName;}


    public int getProductId() {return ProductId;}
    public void setProductId(int ProductId){this.ProductId = ProductId;}

    public int getQuantity() {  return Quantity; }
    public void setQuantity(int Quantity){this.Quantity = Quantity; }

    public double getPrice() {  return Price; }
    public void setPrice(double Price){this.Price = Price; }


    Item ( int ProductId,String ProductName, int Quantity, double Price)
    {
        this.ProductName = ProductName;
        this.ProductId = ProductId;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    public static void showItem()
    {
        for (int i = 0; i < ItemList.size(); i++) {
            System.out.println("Product ID" + ItemList.get(i).getProductId());
            System.out.println("Product Name" + ItemList.get(i).getProductName());
            System.out.println("Product Quantity" + ItemList.get(i).getQuantity());
            System.out.println("Product ID" + ItemList.get(i).getPrice());
        }

    }


    public static void addItem(int ProductId,String ProductName,int Quantity,double Price)
    {
        Item item = new Item( ProductId,ProductName,Quantity,Price);
        ItemList.add(item);
    }

//    public static void loadItem()
//    {
//        try {
//            FileInputStream fileInputStream = new FileInputStream("item_data.txt");
//            Scanner scanner = new Scanner(fileInputStream);
//
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//
//                // Extract item data
//                String[] parts = line.split(",");
//                int code = Integer.parseInt(parts[0]);
//                String name = parts[1];
//                int quantity = Integer.parseInt(parts[2]);
//                double price = Double.parseDouble(parts[3]);
//
//                // Add the item to the itemDatabase (replace with your own addItem method)
//                addItem(code, name, quantity, price);
//            }
//
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            System.err.println("Unable to open item data file for loading...");
//        }
//    }

}
