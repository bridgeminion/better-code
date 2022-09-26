package fb_high_frequency;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i=0; i<order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        for (int i=1; i<words.length; i++) {
            String word1 = words[i-1];
            String word2 = words[i];
            if (!compare(word1, word2, map)) {
                return false;
            }
        }

        return true;
    }
    private boolean compare(String word1, String word2, int[] map) {
        int i = 0;
        while (i < word1.length() && i < word2.length()) {
            if (map[word1.charAt(i)-'a'] != map[word2.charAt(i)-'a']) {
                return map[word1.charAt(i)-'a'] < map[word2.charAt(i)-'a'];
            }
            i++;
        }
        return word1.length() <= word2.length();
    }

    public static void main(String[] args) {
        VerifyingAnAlienDictionary app = new VerifyingAnAlienDictionary();
        String[] words = {"apple","app"};
        System.out.println(app.isAlienSorted(words, "worldabcefghijkmnpqstuvxyz"));
    }

}
