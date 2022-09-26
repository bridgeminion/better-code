package contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectSquares {
    Map<Integer, List<Integer>> xMap;
    Map<Integer, List<Integer>> yMap;

        public DetectSquares() {
            xMap = new HashMap<>();
            yMap = new HashMap<>();
        }

        public void add(int[] point) {
            xMap.putIfAbsent(point[0], new ArrayList<>());
            xMap.get(point[0]).add(point[1]);
            yMap.putIfAbsent(point[1], new ArrayList<>());
            yMap.get(point[1]).add(point[0]);
        }

        public int count(int[] point) {
            int count = 0;
            if (xMap.containsKey(point[0])) {
                List<Integer> list = xMap.get(point[0]);
                for (int y : list) {
                    int distance = Math.abs(point[1] - y);
                    int x1 = point[0] - distance;
                    int x2 = point[0] + distance;
                    count += check(xMap, x1, point[1], y);
                    count += check(xMap, x2, point[1], y);
                }
            }

            return count;

        }

        private int check(Map<Integer, List<Integer>> xMap, int x, int y1, int y2) {
            int count = 0;
            if (xMap.containsKey(x)) {
                int aCount = 0, bCount = 0;
                for (int a : xMap.get(x)) {
                    if (a == y1) {
                        aCount++;
                    } else if (a == y2) {
                        bCount++;
                    }
                }
                if (aCount > 0 && bCount > 0) {
                    count = aCount * bCount;
                }
            }

            return count;
        }

    public static void main(String[] args) {
        DetectSquares instance = new DetectSquares();
        instance.add(new int[]{3, 10});
        instance.add(new int[]{11, 2});
        instance.add(new int[]{3, 2});
        System.out.println(instance.count(new int[]{11, 10}));
        System.out.println(instance.count(new int[]{14, 8}));
        instance.add(new int[]{11, 2});
        System.out.println(instance.count(new int[]{11, 10}));
    }

}
