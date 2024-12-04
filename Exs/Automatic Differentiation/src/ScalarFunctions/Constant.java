package ScalarFunctions;

import ScalarFunctions.DualNumber;

public class Constant implements Function {
  private double constante;

  public Constant(double v) {
    this.constante = v;
  }

  @Override
  public void prettyPrint() {
  }

  @Override
  public DualNumber evaluate(DualNumber dn) {
    return new DualNumber(constante, 0);
  }
}
