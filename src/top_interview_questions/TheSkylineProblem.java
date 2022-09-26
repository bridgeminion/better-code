package top_interview_questions;

import java.util.*;

public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> points = new ArrayList<>();
        for (int[] building : buildings) {
            points.add(Arrays.asList(building[0], -building[2]));
            points.add(Arrays.asList(building[1], building[2]));
        }
        Collections.sort(points, (a, b) -> Integer.compare(a.get(0), b.get(0)) != 0 ? a.get(0) - b.get(0) : Integer.compare(a.get(1), b.get(1)));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b-a);
        List<List<Integer>> result = new ArrayList<>();
        int prev = 0, curr;
        queue.add(0);
        for (List<Integer> point : points) {
            if (point.get(1) < 0) {
                queue.offer(-point.get(1));
            } else {
                queue.remove(point.get(1));
            }
            curr = queue.peek();
            if (prev != curr) {
                result.add(Arrays.asList(point.get(0), curr));
                prev = curr;
            }
        }

        return result;
    }

    public List<int[]> getSkyline1(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b:buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for(int[] h:height) {
            if(h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if(prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        TheSkylineProblem instance = new TheSkylineProblem();
        int[][] buildings = {{8999,10001,1002},{9000,10001,19001},{9001,10001,1000},{9002,10001,999}};
        instance.getSkyline(buildings);
    }

}
