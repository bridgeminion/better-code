package abnb;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        String end = "123450";
        int m = board.length, n = board[0].length;
        StringBuilder start = new StringBuilder();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                start.append(board[i][j]);
            }
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start.toString());
        visited.add(start.toString());
        int steps = 0;
        int[][] dirs = {{1,3}, {0,2,4}, {1,5}, {0,4}, {1,3,5}, {2,4}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String str = queue.poll();
                if (end.equals(str)) {
                    return steps;
                }
                int zeroPosition = str.indexOf("0");
                for (int dir : dirs[zeroPosition]) {
                    String swapped = swap(str, zeroPosition, dir);
                    if (visited.add(swapped)) {
                        queue.offer(swapped);
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;

        return new String(chars);
    }

    public static void main(String[] args) {
        SlidingPuzzle app = new SlidingPuzzle();
        int[][] board = {{1,2,3}, {5,4,0}};
        System.out.println(app.slidingPuzzle(board));
    }
}
