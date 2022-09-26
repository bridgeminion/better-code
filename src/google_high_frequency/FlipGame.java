package google_high_frequency;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        // write your code here
        List<String> result = new ArrayList<>();
        for (int i=0; i<s.length()-1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
                result.add(s.substring(0, i) + "--" + s.substring(i+2));
            }
        }

        return result;
    }

}
