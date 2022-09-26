package top_interview_questions;

/**
 * count consecutive digits using two pointers
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String result = countAndSay(n-1);
        int i=0;
        StringBuilder sb = new StringBuilder();
        while (i < result.length()) {
            int j = i+1;
            while (j < result.length() && result.charAt(j) == result.charAt(i)) {
                j++;
            }
            sb.append(j - i);
            sb.append(result.charAt(i) - '0');
            i = j;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay instance = new CountAndSay();
        System.out.println(instance.countAndSay(4));
    }

}
