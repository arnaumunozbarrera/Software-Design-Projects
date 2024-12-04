package VectorialFunctions;

public class MainVec{
  public static void main(String[] args){
    FunctionVec x1 = new SubscriptVec(1);
    FunctionVec x2 = new SubscriptVec(2);
    FunctionVec gamma = new ConstantVec(0.5, 2);

    FunctionVec func = new SumVec(new MultiplyVec(x1, x1), new MultiplyVec(gamma, new MultiplyVec(x2, x2)));
    // f(x_1, x_2) = x_1^2 + \gamma x_2^2
    // is a convex function with a unique minimum at (0,0)
    double p[] = new double[]{2.0, 3.0};
    DualNumberVec result = func.evaluate(p);


  }
}
