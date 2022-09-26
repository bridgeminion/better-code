package google_high_frequency;

import java.util.Map;
import java.util.TreeMap;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>((e1, e2) -> e2 - e1);
        for (int i=0; i<position.length; i++) {
            treeMap.put(position[i], speed[i]);
        }
        double time = 0;
        int carFleet = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            int distance = target - entry.getKey();
            double timeNeeded = 1.0 * distance/entry.getValue();
            if (timeNeeded > time) {
                carFleet++;
                time = timeNeeded;
            }
        }

        return carFleet;
    }

}
