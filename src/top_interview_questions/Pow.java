package top_interview_questions;

/**
 * use != 0 to cover negative n case
 */
public class Pow {
    public double myPow1(double x, int n) {
        double result = 1;
        int m = n;
        while (m != 0) {
            if (m % 2 != 0) {
                result *= x;
            }
            m /= 2;
            x *= x;
        }

        return n >= 0 ? result : 1/result;
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double result = n % 2 != 0 ? x*myPow(x*x, n/2) : myPow(x*x, n/2);
        return n > 0 ? result : 1/result;
    }

    public static void main(String[] args) {
        Pow instance = new Pow();
        System.out.println(instance.myPow(2.0, -1));
    }

}
