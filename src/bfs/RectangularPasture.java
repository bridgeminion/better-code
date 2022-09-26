package bfs;

import java.io.*;
import java.util.*;

public class RectangularPasture {

    static class Point {
        int x;
        int y;
        int id;
        public Point(int x, int y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
//        PrintWriter pw = new PrintWriter(new FileWriter("bcount.out"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Point> pos = new ArrayList<>();
        for (int i=0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pos.add(new Point (x, y, -1));
        }
        Collections.sort(pos, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        });
        for (int i=1; i <= n; i++){
            pos.get(i-1).id = i;
        }
        Set<Set<Integer>> sets = new HashSet<>();
        for (int i=1; i <= n; i++){
            for (int j=1; j <= i; j++){
                Set<Integer> temp = new HashSet<>();
                for (int k=j; k <= i; k++){
                    temp.add(k);
                }
                sets.add(temp);
            }
        }
        Collections.sort(pos, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.y - o2.y;
            }
        });
        long ans = n*((long)n+1)/2 + 1;
        for (int i=1; i < n; i++){
            Set<Integer> temp = new HashSet<>();
            temp.add(pos.get(i).id);
            temp.add(pos.get(i-1).id);
            if (!sets.contains(temp)){
                ans += i;
            }
        }
        pw.println(ans);
        pw.close();
    }
}
