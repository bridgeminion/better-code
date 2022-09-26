package top_interview_questions;

import java.util.PriorityQueue;

/**
 * use visited to avoid same index put into queue multiple times
 */
public class KthSmallestElementInASortedMatrix {
    class Tuple {
        int x;
        int y;
        int num;
        public Tuple (int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int r = matrix.length, c = matrix[0].length;
        PriorityQueue<Tuple> queue = new PriorityQueue<>((t1, t2) -> t1.num - t2.num);
        queue.offer(new Tuple(0, 0, matrix[0][0]));
        boolean[][] visited = new boolean[r][c];
        int count = 0;
        while (count < k) {
            Tuple tuple = queue.poll();
            count++;
            if (count == k) {
                return tuple.num;
            }
            if (tuple.x < r - 1) {
                if (!visited[tuple.x + 1][tuple.y]) {
                    visited[tuple.x + 1][tuple.y] = true;
                    queue.offer(new Tuple(tuple.x + 1, tuple.y, matrix[tuple.x + 1][tuple.y]));
                }
            }
            if (tuple.y < c - 1) {
                if (!visited[tuple.x][tuple.y + 1]) {
                    visited[tuple.x][tuple.y + 1] = true;
                    queue.offer(new Tuple(tuple.x, tuple.y + 1, matrix[tuple.x][tuple.y+1]));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        KthSmallestElementInASortedMatrix instance = new KthSmallestElementInASortedMatrix();
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(instance.kthSmallest(matrix, 8));
    }

}
