package google_high_frequency;

import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceInString {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<indices.length; i++) {
            int index = indices[i];
            if (s.startsWith(sources[i], index)) {
                map.put(index, i);
            }
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            if (map.containsKey(i)) {
                String target = targets[map.get(i)];
                String source = sources[map.get(i)];
                sb.append(target);
                i += source.length();
            } else {
                sb.append(s.charAt(i++));
            }
        }

        return sb.toString();
    }

}
