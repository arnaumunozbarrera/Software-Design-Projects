package pos_creditcard;

public class PaymentCreditCard extends Payment {
  private String ccnumber;
  private boolean authorized;
  private static final double CC_LIMIT = 1000.0;

  public PaymentCreditCard(String ccnumber, double amountToPay) {
    super(amountToPay);
    this.ccnumber = ccnumber;
    authorized = authorize();
  }

  private boolean authorize() {
    return (amountToPay <= CC_LIMIT);
  }

  public boolean isAuthorized() {
    return authorized;
  }

  @Override
  public void print() {
    if (authorized) {
      System.out.printf("\nAuthorized payment : charged %.2f" +
          " to credit card %s\n", amountToPay, ccnumber);
    } else {
      System.out.printf("\nNon authorized payment of %.2f, " +
          "exceeded limit of %.2f\n", amountToPay, CC_LIMIT);
    }
  }
}
