package google_high_frequency;

import java.util.TreeMap;

public class MyCalendarThree {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public MyCalendarThree() {

    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int max = 0, ongoing = 0;
        for (int value : map.values()) {
            ongoing += value;
            max = Math.max(max, ongoing);
        }

        return max;
    }

}
