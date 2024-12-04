package VectorialFunctions;

public class ConstantVec implements FunctionVec{
  private double constant;
  private int dimensiones;


  public ConstantVec(double value, int dimensiones){
    this.constant = value;
    this.dimensiones = dimensiones;
  }

  @Override
  public DualNumberVec evaluate(double[] vec) {
    int num_dimensions = vec.length;
    double[] uprime = new double[num_dimensions];

    for(int i=0; i<num_dimensions;i++){
      uprime[i] = 0.0;
    }

    return new DualNumberVec(constant, uprime);
  }
}
