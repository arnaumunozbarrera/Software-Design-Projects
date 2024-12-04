package ScalarFunctions;

public class Main {
  public static void main(String[] args) {

    Function halfPi = new Constant(3.141592/2.0);
    Function x = new X(); // f(x) = x;

    Function func = new Sin(new Sum(halfPi, new Multiply(x, x))); // sin(0.5 \pi + x^2);
    System.out.println("sin(0.5 \\pi + x^2), x0= 4.0");

    DualNumber result = func.evaluate(new DualNumber(4.0, 1));

    System.out.println("True");
    System.out.printf("f(%.1f) = %f\n", 4.0, result.u);
    System.out.printf("f(%.1f) = %f\n", 4.0, result.uprime);

    System.out.println("Computed");
    System.out.printf("f(%.1f) = %f\n", 4.0, result.u);
    System.out.printf("f(%.1f) = %f\n", 4.0, result.uprime);

    double errorValue = result.u - result.u;
    System.out.println("error value "+ errorValue);

    double errorDerivative = result.uprime - result.uprime;
    System.out.println("error derivative "+ errorDerivative);

    System.out.println("derivative by finite differences");

    double[] epsilons = {1.0E-6,1.0E-8,1.0E-10,1.0E-12};
    for(double epsilon : epsilons){
      DualNumber resultPlusEpsilon = func.evaluate(new DualNumber(4.0+epsilon,1.0));
      double diferen = (resultPlusEpsilon.u - result.u)/epsilon;
      double error = Math.abs(diferen - result.uprime);
      System.out.printf("for epsilon %e, %f, error %e\n", epsilon, diferen,error);
    }
  }
}
