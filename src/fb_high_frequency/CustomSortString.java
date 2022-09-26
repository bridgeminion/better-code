package fb_high_frequency;

public class CustomSortString {
    public String customSortString(String order, String s) {
        int[] array = new int[26];
        for (char c : s.toCharArray()) {
            array[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (array[c-'a']-- > 0) {
                sb.append(c);
            }
        }
        for (int i=0; i<26; i++) {
            while (array[i]-- > 0) {
                sb.append((char)('a' + i));
            }
        }

        return sb.toString();
    }
}
