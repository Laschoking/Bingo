// fkt so
public class Functions{

  public static int factorial(int n) {
    int fact = 1;
    int i = 1;
    while(i <= n){
      fact *= i;
      i++;
    }
    return fact;
  }

  public static void main(String[] args){
    int n = 5;
    System.out.println("The factorial of " + n + " is " + factorial(n) + ".");
  }


}
