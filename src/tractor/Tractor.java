package tractor;

import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class Tractor {
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    static boolean[][] visited = new boolean[1005][1005];
    static boolean[][] hays = new boolean[1005][1005];
    static int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    static boolean found = false;

    /**
     *     directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
     *     x, y = start[0], start[1]
     *     queue = list()
     *     queue.append((x,y))
     *     count = 0
     *     visited = set()
     *
     *     while queue:
     *
     *         print(queue)
     *         tmp_queue = list()
     *         for x, y in queue:
     *             dfs(x, y, tmp_queue, found_origin)
     *         if found_origin:
     *             return count
     *         count += 1
     *         queue = list(tmp_queue)
     * @param args
     */
    public static void main(String[] args) throws IOException {
//        Tractor instance = new Tractor();
//        Queue<Point> queue = new LinkedList<>();
//        queue.add(new Point(6, 3));
//        int count = 0;
//        // (6, 2), (5, 2), (4, 3), (2, 1), (7, 3), (5, 4), (6, 4)
//        Set<Point> hays = new HashSet<>();
//        hays.add(new Point(6,2));
//        hays.add(new Point(5,2));
//        hays.add(new Point(4,3));
//        hays.add(new Point(2,1));
//        hays.add(new Point(7,3));
//        hays.add(new Point(5,4));
//        hays.add(new Point(6,4));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        for (int i=0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            hays[x][y] = true;
        }
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(sx, sy));
        int count = 0;
        while (true) {
            Queue<Point> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                Point p = queue.poll();
                dfs(p, tempQueue, 100);
                if (found) {
                    System.out.println(count);
                    return;
                }
            }
            count++;
            queue = tempQueue;

        }
    }

    /**
     * def dfs(x, y, tmp_queue, found_origin):
     *
     *         # invalid position
     *         if not 0 <= x < n or not 0 <= y < n:
     *             return
     *
     *         # hay positions
     *         if (x, y) in positions:
     *             positions.remove((x, y))
     *             tmp_queue.append((x, y))
     *             return
     *
     *         if (x, y) in visited:
     *             return
     *         visited.add((x, y))
     *
     *         # reached origin
     *         if (x ,y) == (0, 0):
     *             print("found origin")
     *             found_origin = True
     *             return
     *
     *         for dx, dy in directions:
     *             nx, ny = x + dx, y + dy
     *             dfs(nx, ny, tmp_queue, found_origin)
     */
    public static void dfs(Point p, Queue<Point> queue, int size) {
        if (p.x < 0 || p.x >= size || p.y < 0 || p.y >= size) {
            return;
        }
        if (hays[p.x][p.y]) {
            queue.add(p);
            hays[p.x][p.y] = false;
            return;
        }
        if (visited[p.x][p.y]) {
            System.out.println("you suck");
            return;
        }
        visited[p.x][p.y] = true;
        if (p.x == 0 && p.y == 0) {
            found = true;
            return;
        }
        for (int i=0; i < 4; i++) {
            Point newPoint = new Point(p.x + directions[i][0], p.y + directions[i][1]);
//            if (newPoint.x >= 0 && newPoint.x < 1005 && newPoint.y >= 0 && newPoint.y < 1005 && !visited[newPoint.x][newPoint.y]){
                dfs(newPoint, queue, size);
//            }
        }
    }
}
