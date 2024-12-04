package VectorialFunctions;

import VectorialFunctions.FunctionVec;

public abstract class BinaryOperatorVec implements FunctionVec{
  protected FunctionVec left;
  protected FunctionVec right;

  public BinaryOperatorVec (FunctionVec leftOperand, FunctionVec rightOperand) {
    left = leftOperand;
    right = rightOperand;
  }

  public abstract DualNumberVec evaluate(double[] vec);
}
