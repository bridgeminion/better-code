package contest;

public class SumOfDigitsInBaseK {
    public int sumBase(int n, int k) {
        int sum = 0;
        while (n > 0) {
            sum += n%k;
            n /= k;
        }

        return sum;
    }

    public static void main(String[] args) {
        SumOfDigitsInBaseK instance = new SumOfDigitsInBaseK();
        instance.sumBase(34, 6);
    }

}
