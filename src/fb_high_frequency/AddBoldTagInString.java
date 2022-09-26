package fb_high_frequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddBoldTagInString {
    public String addBoldTag(String s, String[] words) {
        List<int[]> list = new ArrayList<>();
        for (String word : words) {
            int index = s.indexOf(word);
            while (index != -1) {
                list.add(new int[] {index, index + word.length()});
                index = s.indexOf(word, index + 1);
            }
        }
        if (list.isEmpty()) {
            return s;
        }
        List<int[]> merged = merge(list);
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int[] range : merged) {
            sb.append(s.substring(start, range[0]));
            sb.append("<b>");
            sb.append(s.substring(range[0], range[1]));
            sb.append("</b>");
            start = range[1];
        }
        if (start < s.length()) {
            sb.append(s.substring(start));
        }

        return sb.toString();
    }

    private List<int[]> merge(List<int[]> list) {
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        result.add(list.get(0));
        for (int i=1; i<list.size(); i++) {
            int[] curr = list.get(i);
            int[] last = result.get(result.size()-1);
            if (curr[0] <= last[1]) {
                last[1] = Math.max(last[1], curr[1]);
            } else {
                result.add(curr);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        AddBoldTagInString app = new AddBoldTagInString();
        String[] words = {"a", "b", "c"};
        System.out.println(app.addBoldTag("aaabbcc", words));
    }
}
