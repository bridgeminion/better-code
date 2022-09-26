package linkedIn_high_frequency;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        // write your code here
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int i=0; i+9<s.length(); i++) {
            String substr = s.substring(i, i+10);
            if (!set.add(substr)) {
                result.add(substr);
            }
        }

        return new ArrayList(result);
    }
}
