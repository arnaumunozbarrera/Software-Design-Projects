package ScalarFunctions;

import ScalarFunctions.DualNumber;

public interface Function {
  void prettyPrint();
  DualNumber evaluate(DualNumber dn);
  //DualNumber evaluate(double [] x);
}