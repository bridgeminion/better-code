package fb_high_frequency;

public class NextGreaterElementThree {
    public int nextGreaterElement(int n) {
        String str = String.valueOf(n);
        int m = str.length();
        int i = m - 1;
        char[] chars = str.toCharArray();
        boolean found = false;
        while (i > 0 && !found) {
            if (chars[i] > chars[i-1]) {
                found = true;
                int j = m-1;
                while (j >= 0) {
                    if (chars[j] > chars[i-1]) {
                        swap(chars, i-1, j);
                        break;
                    }
                    j--;
                }
                reverse(chars, i, m-1);
            } else {
                i--;
            }
        }

        return !found ? -1 : Integer.valueOf(new String(chars));
    }

    private void swap (char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    private void reverse(char[] chars, int l, int r) {
        while (l < r) {
            swap(chars, l, r);
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        NextGreaterElementThree app = new NextGreaterElementThree();
        System.out.println(app.nextGreaterElement(230241));
    }
}
