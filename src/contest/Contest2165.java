package contest;

public class Contest2165 {
    public long smallestNumber(long num) {
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
        }
        int[] digits = new int[10];
        String str = String.valueOf(num);
        if (isNegative) {
            str = str.substring(1);
        }
        for (char c : str.toCharArray()) {
            digits[c-'0']++;
        }
        StringBuilder sb = new StringBuilder();
        if (isNegative) {
            sb.append("-");
        }
        if (isNegative) {
            for (int i=9; i>=0; i--) {
                int times = digits[i];
                for (int j=0; j<times; j++) {
                    sb.append(i);
                }
            }
            return Long.valueOf(sb.toString());
        } else {
            for (int i=0; i<=9; i++) {
                int times = digits[i];
                for (int j=0; j<times; j++) {
                    sb.append(i);
                }
            }
            if (sb.charAt(1) == '0') {
                String s = sb.toString();
                int k=0;
                while (k<s.length() && s.charAt(k) == '0') {
                    k++;
                }
                s = s.charAt(k) + s.substring(0, k) + s.substring(k+1);
                return Long.valueOf(s);
            }
            return Long.valueOf(sb.toString());
        }


    }

}
