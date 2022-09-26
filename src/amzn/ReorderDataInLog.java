package amzn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReorderDataInLog {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            char c1 = s1.charAt(s1.indexOf(" ")+1);
            char c2 = s2.charAt(s2.indexOf(" ")+1);
            boolean isDigit1 = Character.isDigit(c1);
            boolean isDigit2 = Character.isDigit(c2);
            if (isDigit1 && isDigit2) {
                return 0;
            } else if (isDigit1 && !isDigit2) {
                return 1;
            } else if (!isDigit1 && !isDigit2) {
                String content1 = s1.substring(s1.indexOf(" ")+1);
                String content2 = s2.substring(s2.indexOf(" ")+1);
                if (content1.equals(content2)) {
                    return s1.compareTo(s2);
                }
                return content1.compareTo(content2);
            } else {
                return -1;
            }
        });

        return logs;
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,2,4};
        String[] b = {"1", "3", "5"};
        List<Integer> c = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<String> d = Arrays.asList(b);
        String[] e = d.toArray(new String[d.size()]);
    }
}
