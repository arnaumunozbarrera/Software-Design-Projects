package pos_creditcard;

public class SaleLineItem {
  ProductSpecification productSpecification;
  int quantity;

  public SaleLineItem(ProductSpecification productSpecification, int quantity) {
    this.productSpecification = productSpecification;
    this.quantity = quantity;
  }

  public void incrementQuantity(int qty) {
    quantity += qty;
  }

  public double subtotal() {
    return quantity * productSpecification.getPrice();
  }

  public void print() {
    System.out.printf("%s %d x %.2f = %.2f\n", productSpecification.getName(), quantity,
        productSpecification.getPrice(), subtotal());
  }
}
