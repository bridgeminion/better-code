package google_high_frequency;

import java.util.Map;
import java.util.TreeMap;

public class CalendarTwo {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public CalendarTwo() {

    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (count + entry.getValue() > 2) {
                map.put(start, map.get(start)-1);
                map.remove(start, 0);
                map.put(end, map.get(end)+1);
                map.remove(end, 0);
                return false;
            }
            count += entry.getValue();
        }
        return true;
    }

    public static void main(String[] args) {
        CalendarTwo app = new CalendarTwo();
        app.book(24, 40);
        app.book(43, 50);
        app.book(27, 43);
        app.book(5, 21);
        app.book(30, 40);
        app.book(14, 29);
        app.book(3, 19);
        app.book(3, 14);
        app.book(25, 39);
        app.book(6, 19);
    }

}
