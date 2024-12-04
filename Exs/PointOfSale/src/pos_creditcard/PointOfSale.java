package pos_creditcard;

import java.util.ArrayList;


public class PointOfSale {
  private ProductCatalog productCatalog;
  private ArrayList<Sale> sales;

  private Cash cash;

  private int idLastSale = 0;
  private final String FILE_NAME = "src/pos/catalog.txt";

  public PointOfSale() {
    productCatalog = new ProductCatalog(FILE_NAME);
    sales = new ArrayList<>();
  }

  public int makeNewSale() {
    idLastSale++;
    Sale newSale = new Sale(idLastSale);
    sales.add(newSale);
    return idLastSale;
  }

  public void addLineItemToSale(int idSale, String productName, int quantity) {
    ProductSpecification productSpecification = productCatalog.searchByName(productName);
    Sale sale = searchSaleById(idSale);
    sale.addLineItem(productSpecification, quantity);
  }

  private Sale searchSaleById(int id) {
    for (Sale s : sales) {
      if (s.getId() == id) {
        return s;
      }
    }
    return null;
  }

  public void printReceiptOfSale(int saleId) {
    Sale sale = searchSaleById(saleId);
    sale.printReceipt();
  }

  public void payOneSaleCash(int saleId, double amountHanded, double[] bitllets, int[] quantitat, String method, Cash cash) {
    Sale sale = searchSaleById(saleId);
    sale.payCash(amountHanded, bitllets, quantitat, method, cash);
  }

  public void payOneSaleCreditCard(int saleId, String ccnumber) {
    Sale sale = searchSaleById(saleId);
    sale.payCreditCard(ccnumber);
  }

  public void printPayment(int saleId) {
    Sale sale = searchSaleById(saleId);
    sale.printPayment();
  }

  public boolean isSalePaid(int id) {
    return searchSaleById(id).isPaid();
  }

  // this is for the user interface
  public ArrayList<String> getProductNames() {
    return productCatalog.getProductNames();
  }


}

