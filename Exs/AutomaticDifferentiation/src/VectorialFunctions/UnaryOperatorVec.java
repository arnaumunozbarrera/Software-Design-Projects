package VectorialFunctions;

import VectorialFunctions.DualNumberVec;

public abstract class UnaryOperatorVec implements FunctionVec{
  protected FunctionVec op;

  public UnaryOperatorVec (FunctionVec unaryOp){
    op = unaryOp;
  }

  public abstract DualNumberVec evaluate(double[] vec);
}
