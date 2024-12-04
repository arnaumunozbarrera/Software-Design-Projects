package ScalarFunctions;

import ScalarFunctions.DualNumber;

public class Sin extends UnaryOperator {

  public Sin (Function f){
    super(f);
  }

  @Override
  public void prettyPrint() {
    System.out.print("sin(");
    System.out.print(")");

  }

  @Override
  public DualNumber evaluate(DualNumber dn) {
    DualNumber evaluatedInner = op.evaluate(dn);
    return new DualNumber(Math.sin(evaluatedInner.u), Math.cos(evaluatedInner.u)*evaluatedInner.uprime);
  }
}
