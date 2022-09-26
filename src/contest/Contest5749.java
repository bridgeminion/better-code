package contest;


public class Contest5749 {
    public int getMinSwaps(String num, int k) {
        String temp = num;
        for (int i=0; i<k; i++) {
            temp = getNextPermutation(temp);
        }
        int i=0, count=0;
        while (i < num.length()) {
            if (num.charAt(i) != temp.charAt(i)) {
                count++;
            }
            i++;
        }

        return count-1;
    }

    private String getNextPermutation(String num) {
        char[] chars = num.toCharArray();
        int i = chars.length - 1;
        while (i > 0) {
            if (chars[i] > chars[i-1]) {
               break;
            }
            i--;
        }
        swapRange(chars, i, num.length()-1);
        int toSwap = i-1;
        while (i < chars.length) {
            if (chars[i] > chars[toSwap]) {
                swap(chars, i, toSwap);
                break;
            }
            i++;
        }

        return new String(chars);
    }

    private void swapRange(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
    }

    private void swap(char[] chars, int start, int end) {
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
    }

    public static void main(String[] args) {
        Contest5749 instance = new Contest5749();
        System.out.println(instance.getMinSwaps("11112", 4));
    }

}
