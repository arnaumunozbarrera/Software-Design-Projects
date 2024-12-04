package ScalarFunctions;

import ScalarFunctions.DualNumber;

public class X  implements Function {
  public X() {
    // void
  }

  @Override
  public void prettyPrint() {
  }

  public DualNumber evaluate(DualNumber dn) {
    return new DualNumber(dn.u, 1.0);
  }
}
