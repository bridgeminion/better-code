package fb_high_frequency;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((p1, p2) -> Double.compare(distance(p2), distance(p1)));
        for (int[] point : points) {
            queue.offer(point);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[][] result = new int[k][2];
        while (k > 0) {
            result[--k] = queue.poll();
        }

        return result;
    }

    private double distance(int[] point) {
        return Math.pow(point[0], 2) + Math.pow(point[1], 2);
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin app = new KClosestPointsToOrigin();
        int[][] points = {{3,3},{5,-1},{-2,4}};
        System.out.println(app.kClosest(points, 2));
    }

}
