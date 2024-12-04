package VectorialFunctions;

public class MultiplyVec extends BinaryOperatorVec{

  public MultiplyVec(FunctionVec leftOperand, FunctionVec rightOperand) {
    super(leftOperand, rightOperand);
  }

  @Override
  public DualNumberVec evaluate(double[] vec) {
    DualNumberVec dn1 = left.evaluate(vec);
    DualNumberVec dn2 = right.evaluate(vec);

    int num_dimensions = dn1.uprime.length;
    double[] uprime = new double[num_dimensions];

    for(int i =0; i<num_dimensions; i++){
      uprime[i]=dn1.uprime[i]*dn2.uprime[i];
    }

    return new DualNumberVec(dn1.u*dn2.u, uprime);
  }

}
