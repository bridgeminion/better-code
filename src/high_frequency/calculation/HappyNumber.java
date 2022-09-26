package high_frequency.calculation;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum;
        while (true) {
            sum = 0;
            while (n != 0) {
                sum += Math.pow(n%10, 2);
                n /= 10;
            }
            if (sum == 1) {
                return true;
            }
            if (!set.add(sum)) {
                return false;
            }
            n = sum;
        }
    }

    public static void main(String[] args) {
        HappyNumber instance = new HappyNumber();
        System.out.println(instance.isHappy(19));
    }

}
