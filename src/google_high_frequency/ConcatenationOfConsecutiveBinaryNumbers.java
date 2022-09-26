package google_high_frequency;

public class ConcatenationOfConsecutiveBinaryNumbers {
    public int concatenatedBinary(int n) {
        int digits = 0, MOD = 1000000007;
        long result = 0;
        for(int i = 1; i <= n; i++){
			/* if "i" is a power of 2, then we have one additional digit in
			   its the binary equivalent compared to that of i-1 */
            if((i & (i - 1)) == 0) digits++;
            System.out.println(result + "<<" + digits + "+" + i);
            result = ((result << digits) + i) % MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        ConcatenationOfConsecutiveBinaryNumbers app = new ConcatenationOfConsecutiveBinaryNumbers();
        System.out.println(app.concatenatedBinary(6));
    }
}
