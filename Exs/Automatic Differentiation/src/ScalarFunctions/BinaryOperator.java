package ScalarFunctions;

import ScalarFunctions.DualNumber;

public abstract class BinaryOperator implements Function{
  protected Function left;
  protected Function right;

  public BinaryOperator(Function leftOperand, Function rightOperand) {
    left = leftOperand;
    right = rightOperand;
  }

  protected void prettyPrint(String symbolOperator) {
    System.out.print("(");
    left.prettyPrint();
    System.out.print(")");
    System.out.print(symbolOperator);
    System.out.print("(");
    right.prettyPrint();
    System.out.print(")");
  }

  public abstract DualNumber evaluate(DualNumber dn);
}
