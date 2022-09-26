package fb_high_frequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            String str = getBase(string);
            map.putIfAbsent(str, new ArrayList<>());
            map.get(str).add(string);
        }
        return map.values().stream().collect(Collectors.toList());
    }

    private String getBase(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("0,");
        for (int i=1; i<str.length(); i++) {
            sb.append((str.charAt(i) - str.charAt(i-1) + 26) % 26).append(",");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        GroupShiftedStrings app = new GroupShiftedStrings();
        String[] strings = {"abc","bcd","acef","xyz","az","ba","a","z","al"};
        System.out.println(app.groupStrings(strings));
    }

}
