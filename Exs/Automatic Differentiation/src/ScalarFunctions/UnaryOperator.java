package ScalarFunctions;

import ScalarFunctions.DualNumber;

public abstract class UnaryOperator implements Function {
  protected Function op;

  public UnaryOperator(Function unaryOp) {
    op = unaryOp;
  }

  public abstract DualNumber evaluate(DualNumber dn);
}
