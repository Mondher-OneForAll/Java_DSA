package DSA;

public class Recursion {
    public static void main(String[] args) {

        System.out.println("Factorial of  7 is : " + factorial(7));
        System.out.println("2^8 = " + power(2,8));
    }

    private static int power(int base, int exponent) {
        if (exponent < 1) return 1;
        else return base * power(base, exponent - 1);
    }

    private static int factorial(int n) {
        if (n == 1) return 1;
        else return n * factorial(n - 1);
    }
}
