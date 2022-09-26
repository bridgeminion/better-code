package rotate._186;

public class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0, end = 0;
        while (end < s.length()) {
            // remember always add boundary check in while loop with index++
            while (end < s.length() && s.charAt(end) != ' ') {
                end++;
            }
            rotate(chars, start, end - 1);
            end++;
            start = end;
        }
        rotate(chars, 0, chars.length-1);
        return new String(chars);
    }

    public void rotate(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("the sky is blue"));
    }

}
