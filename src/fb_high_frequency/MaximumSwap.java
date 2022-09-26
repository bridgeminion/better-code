package fb_high_frequency;

public class MaximumSwap {
    public int maximumSwap1(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int max = -1, maxIndex = -1;
        for (int i=0; i<chars.length; i++) {
            for (int j=i+1; j<chars.length; j++) {
                if (chars[j] > chars[i]) {
                    if (chars[j] > max) {
                        max = chars[j];
                        maxIndex = j;
                    } else if (chars[j] == max) {
                        maxIndex = j;
                    }
                }
            }
            if (max != -1) {
                char tmp = chars[i];
                chars[i] = chars[maxIndex];
                chars[maxIndex] = tmp;
                return Integer.valueOf(new String(chars));
            }
        }

        return num;
    }

    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int[] digits = new int[10];
        for (int i=0; i<chars.length; i++) {
            digits[chars[i] - '0'] = i;
        }
        for (int i=0; i<chars.length; i++) {
            for (int j=9; j>chars[i]-'0'; j--) { // loop from 9 to num greater than chars[i]
                if (digits[j] > i) { // check if position is after i
                    char tmp = chars[i];
                    chars[i] = chars[digits[j]];
                    chars[digits[j]] = tmp;

                    return Integer.valueOf(String.valueOf(chars));
                }
            }
        }

        return num;
    }


    public static void main(String[] args) {
        MaximumSwap app = new MaximumSwap();
        System.out.println(app.maximumSwap(1993));
    }

}
