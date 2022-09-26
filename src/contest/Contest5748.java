package contest;

import java.util.*;

public class Contest5748 {
    static class Point {
        int start;
        int type;
        int size;

        public Point(int start, int type, int size) {
            this.start = start;
            this.type = type;
            this.size = size;
        }
    }
    public int[] minInterval(int[][] intervals, int[] queries) {
        List<Point> pointList = new ArrayList<>();
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            pointList.add(new Point(start, 1, end - start + 1));
            pointList.add(new Point(end+1, 2, end - start + 1));
        }
        for (int query : queries) {
            pointList.add(new Point(query, 3, 0));
        }
        Collections.sort(pointList, (p1, p2) -> p1.start - p2.start);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (Point point : pointList) {
            if (point.type == 1) {
                map.put(point.size, map.getOrDefault(point.size, 0) + 1);
            } else if (point.type == 2) {
                map.put(point.size, map.get(point.size) - 1);
                if (map.get(point.size) == 0) {
                    map.remove(point.size);
                }
            } else {
                if (map.isEmpty()) {
                    resultMap.put(point.start, -1);
                } else {
                    resultMap.put(point.start, map.firstKey());
                }
            }
        }
        int[] result = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
            result[i] = resultMap.get(queries[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Contest5748 instance = new Contest5748();
        int[][] intervals = {{2,3},{2,5},{1,8},{20,25}};
        int[] queries = {2,19,5,22};
        instance.minInterval(intervals, queries);
    }

}
