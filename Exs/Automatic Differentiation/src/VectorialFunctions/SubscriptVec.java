package VectorialFunctions;

public class SubscriptVec implements FunctionVec{
  private int index;

  public SubscriptVec(int index) {
    this.index = index-1;
  }

  @Override
  public DualNumberVec evaluate(double[] x) { // not a dual number anymore
    int num_dimensions = x.length;
    double[] numUprime = new double[num_dimensions];
    for (int i=0; i<num_dimensions; i++) {
      numUprime[i] = (i==index) ? 1.0 : 0.0;
    }
    return new DualNumberVec(x[index], numUprime);
  }
}
