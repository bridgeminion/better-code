package contest;

import java.util.HashSet;
import java.util.Set;

public class Contest1839 {
    public int longestBeautifulSubstring(String word) {
        int max = 0, left = 0;
        Set<Character> seen = new HashSet<>();
        char lastSeen = 'a';
        for (int i=0; i<word.length(); i++) {
            if (word.charAt(i) >= lastSeen) {
                lastSeen = word.charAt(i);
                seen.add(lastSeen);
            } else {
                if (seen.size() == 5) {
                    max = Math.max(max, i - left);
                }
                left = i;
                seen = new HashSet<>();
                lastSeen = word.charAt(i);
                seen.add(lastSeen);
            }
        }
        if (seen.size() == 5) {
            max = Math.max(max, word.length() - left);
        }

        return max;
    }

    public static void main(String[] args) {
        Contest1839 instance = new Contest1839();
        instance.longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu");
        instance.longestBeautifulSubstring("aeeeiiiioooauuuaeiou");
    }

}
