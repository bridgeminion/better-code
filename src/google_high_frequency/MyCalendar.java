package google_high_frequency;

import java.util.TreeMap;
import java.util.TreeSet;

public class MyCalendar {
    private TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer lowerKey = map.lowerKey(end);
        if (lowerKey != null) {
            if (map.get(lowerKey) > start) {
                return false;
            }
        }
        map.put(start, end);
        return true;
    }

}
