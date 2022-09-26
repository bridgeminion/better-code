package google_high_frequency;

import java.util.HashMap;
import java.util.Map;

public class TheMaze {
    public boolean hasPath1(int[][] maze, int[] start, int[] destination) {
        int r = maze.length, c = maze[0].length;
        boolean[][] visited = new boolean[r][c];
        return dfs1(maze, start[0], start[1], destination[0], destination[1], r, c, visited);
    }

    private boolean dfs1(int[][] maze, int x, int y, int destX, int destY, int r, int c, boolean[][] visited) {
        if (x < 0 || x >= r || y < 0 || y >= c || visited[x][y] || maze[x][y] != 0) {
            return false;
        }
        if (x == destX && y == destY) {
            return true;
        }
        visited[x][y] = true;
        int[][] moves = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        boolean result = false;
        for (int[] move : moves) {
            int newX = x, newY = y;
            while (newX >= 0 && newX < r && newY >= 0 && newY < c && maze[newX][newY] == 0) {
                newX += move[0];
                newY += move[1];
            }
            newX -= move[0];
            newY -= move[1];
            result |= dfs1(maze, newX, newY, destX, destY, r, c, visited);
        }

        return result;
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int r = maze.length, c = maze[0].length;
        boolean[][] visited = new boolean[r][c];
        Map<Integer, Boolean> map = new HashMap<>();
        return dfs(maze, start[0], start[1], destination[0], destination[1], r, c, visited, map);
    }

    private boolean dfs(int[][] maze, int x, int y, int destX, int destY, int r, int c, boolean[][] visited, Map<Integer, Boolean> map) {
        if (x < 0 || x >= r || y < 0 || y >= c || visited[x][y] || maze[x][y] != 0) {
            return false;
        }
        if (x == destX && y == destY) {
            return true;
        }
        if (map.containsKey(x*c+y)) {
            return map.get(x*c + y);
        }
        visited[x][y] = true;
        int[][] moves = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        boolean result = false;
        for (int[] move : moves) {
            int newX = x, newY = y;
            while (newX >= 0 && newX < r && newY >= 0 && newY < c && maze[newX][newY] == 0) {
                newX += move[0];
                newY += move[1];
            }
            newX -= move[0];
            newY -= move[1];
            result |= dfs(maze, newX, newY, destX, destY, r, c, visited, map);
        }

        map.put(x*c + y, result);
        return result;
    }

    public static void main(String[] args) {
        TheMaze app = new TheMaze();
        int[][] maze = {
                         {0,0,1,0,0},
                         {0,0,0,0,0},
                         {0,0,0,1,0},
                         {1,1,0,1,1},
                         {0,0,0,0,0}
                        };
        System.out.println(app.hasPath(maze, new int[]{0,4}, new int[]{4,4}));
    }

}
