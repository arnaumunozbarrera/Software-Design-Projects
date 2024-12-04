package ScalarFunctions;

import java.util.Arrays;
import java.util.Vector;

public class DualNumber {
  public double u;
  public double uprime;

  DualNumber(double numU, double numUprime) {
    this.u = numU;
    this.uprime = numUprime;
  }
  
  double getU() { return u; }

  double getUprime() { return uprime; }
}
