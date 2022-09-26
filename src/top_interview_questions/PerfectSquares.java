package top_interview_questions;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int count = -1;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int sum = queue.poll();
                if (sum == n) {
                    return count;
                }
                for (int j=1; j<n/2; j++) {
                    int newSum = sum + (int)Math.pow(j, 2);
                    if (newSum <= n) {
                        queue.offer(newSum);
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        PerfectSquares instance = new PerfectSquares();
        System.out.println(instance.numSquares(13));
    }

}
