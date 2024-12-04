package pos_creditcard;

public class ProductSpecification {
  private String name;
  private double price; // in Euros

  public ProductSpecification(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }
}
