package fb_high_frequency;

public class ValidPalindromeTwo {
    int count = 1;
    public boolean validPalindromeRecursive(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        char[] chars = s.toCharArray();
        return helper(chars, 0, s.length()-1);

    }

    private boolean helper(char[] chars, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (chars[start] == chars[end]) {
            return helper(chars, start + 1, end - 1);
        }
        if (count == 1) {
            count--;
            return helper(chars, start + 1, end) || helper(chars, start, end - 1);
        }
        return false;
    }

    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left, right-1) || isPalindrome(s, left + 1, right);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
