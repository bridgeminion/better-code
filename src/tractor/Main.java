package tractor;

import java.io.*;
import java.util.*;


class Point {
    int x;
    int y;
    int numberOfBales;

    public Point(int x, int y, int numberOfBales){
        this.x = x;
        this.y = y;
        this.numberOfBales = numberOfBales;
    }


}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int[] starting = new int[]{sx, sy};
        int[][] bales = new int[1005][1005];
        for (int i=0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            bales[x][y] = 1;
        }
        System.out.println(getMinNumberOfHales(starting, bales));
    }

    public static int getMinNumberOfHales(int[] starting, int[][] bales){
        if(starting == null || starting.length == 0 || bales.length == 0){
            return 0;
        }
        boolean[][] visited = new boolean[1005][1005];
        PriorityQueue<Point> locations = new PriorityQueue<Point>((a,b) -> (a.numberOfBales - b.numberOfBales));
        locations.add(new Point(starting[0], starting[1], 0));

        while(!locations.isEmpty()){
            Point curr = locations.poll();
            if(curr.x == 0 && curr.y == 0){
                return curr.numberOfBales;
            }
            addNeighbors(curr, locations, bales, visited);
        }

        return -1;
    }

    private static void addNeighbors(Point curr, PriorityQueue<Point> allPoints, int[][] bales, boolean[][] visited){

        TreeSet<Integer> a = new TreeSet<>();
        int[][] directions = new int[][]{{1, 0}, {0,1}, {-1, 0}, {0, -1}};
        for(int i = 0; i < directions.length; i++){
            int nextX = curr.x + directions[i][0];
            int nextY = curr.y + directions[i][1];
            if (nextX >= 0 && nextX < 1005 && nextY >= 0 && nextY < 1005) {
                if (!visited[nextX][nextY]) {
                    Point point = new Point(nextX, nextY, curr.numberOfBales);
                    if (bales[nextX][nextY] == 1) {
                        point.numberOfBales++;
                    }
                    allPoints.add(point);
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
}
