package top_interview_questions;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. if add sign: (numerator > 0 ^ denominator > 0
 * 2. to handle −2147483648/-1, need to cast both to long when abs
 * 3. use map to record reminder -> index
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(numerator > 0 ^ denominator > 0 ? "-" : "");
        long n1 = Math.abs((long)numerator);
        long n2 = Math.abs((long)denominator);
        sb.append(n1/n2);
        n1 %= n2;
        if (n1 == 0) {
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (n1 != 0) {
            if (map.containsKey(n1)) {
                sb.insert(map.get(n1), "(");
                sb.append(")");
                return sb.toString();
            } else {
                map.put(n1, sb.length());
            }
            n1 *= 10;
            sb.append(n1/n2);
            n1 %= n2;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        FractionToRecurringDecimal instance = new FractionToRecurringDecimal();
        System.out.println(instance.fractionToDecimal(5, 3));
    }
}
