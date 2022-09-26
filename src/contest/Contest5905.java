package contest;

import java.util.*;

public class Contest5905 {
    class Point {
        int x;
        int time;
        public Point(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[1]).add(edge[0]);
        }
        PriorityQueue<Point> queue = new PriorityQueue<>((p1, p2) -> p1.time == p2.time ? p2.x - p1.x : p1.time - p2.time);
        queue.offer(new Point(1, 0));
        int first = -1, se;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.x == n) {
                if (first == -1) {
                    first = point.time;
                } else if (point.time > first) {
                    return point.time;
                }
            }
            for (int p : graph.get(point.x)) {
                int timeSpent = point.time ;
                int times = timeSpent/change;
                if (times % 2 == 1) {
                    timeSpent = change * (times + 1);
                }
                queue.offer(new Point(p, timeSpent + time));
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Contest5905 app = new Contest5905();
        int[][] edges = {{1,2}};
        System.out.println(app.secondMinimum(2, edges, 3, 2));
    }

}
