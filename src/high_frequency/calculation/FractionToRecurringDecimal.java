package high_frequency.calculation;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. handle negative integer
 * 2. handle overflow
 * 3. use Map to track starting index of a num
 * 4. handle 0 case
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        sb.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        sb.append(n/d);
        long num = n % d;
        if (num == 0) {
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());
        while (num != 0) {
            num *= 10;
            sb.append(num/d);
            num %= d;
            if (map.containsKey(num)) {
                sb.insert(map.get(num), "(");
                sb.append(")");
                break;
            } else {
                map.put(num, sb.length());
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        FractionToRecurringDecimal instance = new FractionToRecurringDecimal();
        instance.fractionToDecimal(2, 3);
    }

}
