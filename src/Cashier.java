import java.util.Scanner;
import java.util.LinkedList;
import java.util.HashMap;
public class Cashier extends Item {

    private double Amount,TotalDiscount;
    private double DiscountPercent = 0.20;

    Cashier(String ProductName, int ProductId, int Quantity, double Price) {
        super( ProductId,ProductName, Quantity, Price);
    }

    public double getAmount() {  return Amount; }
    public void setAmount(double Price){this.Amount = Amount; };


    public double getTotalDiscount() {  return TotalDiscount; }
    public void setTotalDiscount(double TotalDiscount){this.TotalDiscount = TotalDiscount; };

    public static LinkedList<Item> CartList = new LinkedList<>();

    }
