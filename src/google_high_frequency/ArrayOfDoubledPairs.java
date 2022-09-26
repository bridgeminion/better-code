package google_high_frequency;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] arr) {
        int m = arr.length;
        if (m % 2 == 1) {
            return false;
        }
        Map<Integer, Integer> map = new TreeMap<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) {
                return a - b;
            }
            return Math.abs(a) - Math.abs(b);
        });
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 0) {
                continue;
            }
            if (!map.containsKey(key*2) || map.get(key*2) < map.get(key)) {
                return false;
            }
            map.put(key*2, map.get(key*2) - map.get(key));
        }

        return true;
    }

}
