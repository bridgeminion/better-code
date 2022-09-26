package fb_high_frequency;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    class Entry {
        int x;
        int y;
        int distance;
        public Entry(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public void wallsAndGates(int[][] rooms) {
        int r = rooms.length, c = rooms[0].length;
        Queue<Entry> queue = new LinkedList<>();
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Entry(i, j, 0));
                }
            }
        }
        int[][] moves = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Entry e = queue.poll();
                for (int[] move : moves) {
                    int nextX = e.x + move[0];
                    int nextY = e.y + move[1];
                    if (nextX >= 0 && nextX < r && nextY >= 0 && nextY < c && rooms[nextX][nextY] == Integer.MAX_VALUE) {
                        rooms[nextX][nextY] = e.distance + 1;
                        queue.offer(new Entry(nextX, nextY, e.distance+1));
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        WallsAndGates app = new WallsAndGates();
        int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        app.wallsAndGates(rooms);
    }
}
