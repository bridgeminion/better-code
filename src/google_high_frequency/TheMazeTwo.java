package google_high_frequency;

import java.util.PriorityQueue;

public class TheMazeTwo {
    class Entry {
        int x;
        int y;
        int distance;
        public Entry (int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int r = maze.length, c = maze[0].length;
        PriorityQueue<Entry> queue = new PriorityQueue<>((e1, e2) -> e1.distance - e2.distance);
        queue.offer(new Entry(start[0], start[1], 0));
        int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while (!queue.isEmpty()) {
            Entry entry = queue.poll();
            if (entry.x == destination[0] && entry.y == destination[1]) {
                return entry.distance;
            }
            maze[entry.x][entry.y] = -1;
            for (int[] move : moves) {
                int x = entry.x;
                int y = entry.y;
                while (x >= 0 && x < r && y >= 0 && y < c && maze[x][y] != 1) {
                    x += move[0];
                    y += move[1];
                }
                x -= move[0];
                y -= move[1];
                if (maze[x][y] == 0) {
                    queue.offer(new Entry(x, y, (Math.abs(x - entry.x) + Math.abs(y - entry.y) + entry.distance)));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        TheMazeTwo app = new TheMazeTwo();
        int[][] maze = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        System.out.println(app.shortestDistance(maze, new int[]{0,4}, new int[]{4,4}));
    }

}
