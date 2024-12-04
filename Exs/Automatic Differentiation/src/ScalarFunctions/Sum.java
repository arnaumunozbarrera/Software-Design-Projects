package ScalarFunctions;

import ScalarFunctions.DualNumber;

public class Sum extends BinaryOperator{
  public Sum(Function leftOperand, Function rightOperand) {
    super(leftOperand, rightOperand);
  }

  @Override
  public void prettyPrint() {
    prettyPrint("+");
  }

  @Override
  public DualNumber evaluate(DualNumber dn) {
    DualNumber dn1 = left.evaluate(dn);
    DualNumber dn2 = right.evaluate(dn);
    return new DualNumber(dn1.u+dn2.u, dn1.uprime+dn2.uprime);
  }
}
