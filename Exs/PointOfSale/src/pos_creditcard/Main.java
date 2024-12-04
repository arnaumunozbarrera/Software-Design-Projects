package pos_creditcard;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    PointOfSale pointOfSale = new PointOfSale();
    // Some customers arrive, sit at a table, the waiter comes and makes a new sale.
    // Then takes the order : 4 Moritz and 1 Coca-cola
    Cash cash = new Cash();

    cash.printCash();

    int idSale = pointOfSale.makeNewSale();
    pointOfSale.addLineItemToSale(idSale, "Moritz", 4);
    pointOfSale.addLineItemToSale(idSale, "Coca-cola", 1);
    // later 2 more Coca-colas
    pointOfSale.addLineItemToSale(idSale, "Coca-cola", 2);
    // ask for the bill and the waiter prints the receipt:
    //Sale 1
    //03-03-2024 10:57
    //Moritz 4 x 1.9 = 7.6
    //Coca-cola 3 x 1.2 = 3.6
    //Total 11.2

    pointOfSale.printReceiptOfSale(idSale);
    double handedAmount = 20;

    Scanner myObj = new Scanner(System.in); // Crea un objeto Scanner
    System.out.println("Specify change method:");
    String method = myObj.nextLine();

    double[] bitllets = {10};
    int[] quantitat = {2};
    pointOfSale.payOneSaleCash(idSale, handedAmount, bitllets, quantitat, method, cash);
    pointOfSale.printPayment(idSale);
    System.out.println("---------------------------------");

    int idSale2 = pointOfSale.makeNewSale();
    pointOfSale.addLineItemToSale(idSale2, "Nestea", 1);
    pointOfSale.printReceiptOfSale(idSale2);
    pointOfSale.payOneSaleCreditCard(idSale2, "4502360043567891");
    pointOfSale.printPayment(idSale2);
  }
}
  // the old main
  /*
  public static void main(String[] args) {
    ArrayList<ProductSpecification> products = new ArrayList();
    ArrayList<Sale> sales = new ArrayList<>();

    ProductSpecification cocacola = new ProductSpecification("Coca-cola", 1.20);
    ProductSpecification moritz = new ProductSpecification("Nestea", 1.50);
    //...
    products.add(cocacola);
    products.add(moritz); // why do we want products ?
    //...
    Sale newSale1 = new Sale(1);
    sales.add(newSale1); // why do we want sales ?
    // later
    Sale newSale2 = new Sale(1);
    sales.add(newSale2);
    //...
    newSale1.saleLineItems.add(new SaleLineItem(moritz, 4)); // public attribute
    newSale1.saleLineItems.add(new SaleLineItem(cocacola, 3));
*/




