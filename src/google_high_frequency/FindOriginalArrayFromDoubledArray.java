package google_high_frequency;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int change : changed) {
            map.put(change, map.getOrDefault(change, 0) + 1);
        }
        Arrays.sort(changed);
        int[] result = new int[changed.length/2];
        int i = 0;
        if (map.getOrDefault(0, 0) % 2 == 1) {
            return new int[]{};
        } else {
            for (int j=0; j<map.getOrDefault(0, 0)/2; j++) {
                result[i++] = 0;
            }
        }
        for (int n : changed) {
            if (map.get(n) == 0) {
                continue;
            }
            int dou = n > 0 ? n*2 : n/2;
            if (map.getOrDefault(dou, 0) < map.get(n)) {
                return new int[]{};
            } else {
                map.put(dou, map.get(dou) - map.get(n));
                for (int j=0; j<map.get(n); j++) {
                    result[i++] = n;
                }
                map.put(n, 0);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        FindOriginalArrayFromDoubledArray app = new FindOriginalArrayFromDoubledArray();
        int[] changed = {2,1,2,4,2,4};
        System.out.println(app.findOriginalArray(changed));
    }

}
