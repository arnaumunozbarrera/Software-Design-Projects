package VectorialFunctions;

public class SinVec implements FunctionVec{
  private FunctionVec func;

  public SinVec(FunctionVec func) { this.func = func; }

  @Override
  public DualNumberVec evaluate(double[] x) {
    DualNumberVec dn = func.evaluate(x);
    int num_dimensions = dn.uprime.length;
    double[] uprime = new double[num_dimensions];
    for (int i=0; i<num_dimensions ; i++) {
      uprime[i] = dn.uprime[i]*Math.cos(dn.u);
    }
    return new DualNumberVec(Math.sin(dn.u), uprime);
  }


}
