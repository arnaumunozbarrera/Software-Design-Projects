package pos;

public class PaymentInCash {
  double amount; // Euros

  public PaymentInCash(double amount) {
    this.amount = amount;
  }

  public double change(double totalSale) {
    double change = amount - totalSale; // better than sale.total(), avoids a dependence
    assert change >= 0;
    return change;
  }

  public double getAmount() {
    return amount;
  }
}
