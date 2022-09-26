import java.io.*;
import java.util.*;

public class Mirrors {

    static class Mirror {
        int x;
        int y;
        int dir;

        public Mirror(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Mirror mirror = (Mirror) o;
            return x == mirror.x &&
                    y == mirror.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static Map<Mirror, Integer> count = new HashMap<>();

    public static int getDir (int d, int md){
        if (md == -1){
            return -1;
        }
        if (d == 0){
            if (md == 0){
                return 1;
            }
            return 3;
        }
        if (d == 1){
            if (md == 0){
                return 0;
            }
            return 2;
        }
        if (d == 2){
            if (md == 0){
                return 3;
            }
            return 1;
        }
        if (d == 3){
            if (md == 0){
                return 2;
            }
            return 0;
        }
        return -1;
    }

    public static Mirror getNext (int x, int y, int dir, Map<Integer, TreeSet<Mirror>> xmap, Map<Integer, TreeSet<Mirror>> ymap){
        if (dir == 0){
            Mirror ret = xmap.get(x).ceiling(new Mirror (x, y+1, dir));
            if (ret == null){
                return new Mirror (0, 0, -2);
            }
            return new Mirror (ret.x, ret.y, getDir (dir, ret.dir));
        }
        if (dir == 1){
            Mirror ret = ymap.get(y).ceiling(new Mirror (x+1, y, dir));
            if (ret == null){
                return new Mirror (0, 0, -2);
            }
            return new Mirror (ret.x, ret.y, getDir (dir, ret.dir));
        }
        if (dir == 2){
            Mirror ret = xmap.get(x).floor(new Mirror (x, y-1, dir));
            if (ret == null){
                return new Mirror (0, 0, -2);
            }
            return new Mirror (ret.x, ret.y, getDir (dir, ret.dir));
        }
        if (dir == 3){
            Mirror ret = ymap.get(y).floor(new Mirror (x-1, y, dir));
            if (ret == null){
                return new Mirror (0, 0, -2);
            }
            return new Mirror (ret.x, ret.y, getDir (dir, ret.dir));
        }
        return new Mirror (0, 0, -2);
    }

    public static boolean simulate (Map<Integer, TreeSet<Mirror>> xmap, Map<Integer, TreeSet<Mirror>> ymap){
        int x = 0;
        int y = 0;
        int dir = 1;
        while (true){
            Mirror next = getNext(x, y, dir, xmap, ymap);
            if (next.dir == -1){
                return true;
            }
            if (next.dir == -2){
                return false;
            }
            count.putIfAbsent(next, 0);
            count.put(next, count.get(next)+1);
            if (count.get(next) >= 3){
                return false;
            }
            x = next.x;
            y = next.y;
            dir = next.dir;
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("trapped.in"));
//        PrintWriter pw = new PrintWriter(new FileWriter("trapped.out"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int bx = Integer.parseInt(st.nextToken());
        int by = Integer.parseInt(st.nextToken());
        List<Mirror> mirrors = new ArrayList<>();
        mirrors.add(new Mirror(bx, by, -1));
        Map<Integer, TreeSet<Mirror>> xmap = new HashMap<>();
        Map<Integer, TreeSet<Mirror>> ymap = new HashMap<>();
        xmap.putIfAbsent(bx, new TreeSet<>(new Comparator<Mirror>() {
            @Override
            public int compare(Mirror o1, Mirror o2) {
                return o1.y - o2.y;
            }
        }));
        ymap.putIfAbsent(by, new TreeSet<>(new Comparator<Mirror>() {
            @Override
            public int compare(Mirror o1, Mirror o2) {
                return o1.x - o2.x;
            }
        }));
        xmap.get(bx).add(new Mirror (bx, by, -1));
        ymap.get(by).add(new Mirror (bx, by, -1));
        for (int i=0; i < n; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st1.nextToken());
            int y = Integer.parseInt(st1.nextToken());
            char temp = st1.nextToken().charAt(0);
            int dir;
            if (temp == '/'){
                dir = 0;
            }
            else {
                dir = 1;
            }
            xmap.putIfAbsent(x, new TreeSet<>(new Comparator<Mirror>() {
                @Override
                public int compare(Mirror o1, Mirror o2) {
                    return o1.y - o2.y;
                }
            }));
            ymap.putIfAbsent(y, new TreeSet<>(new Comparator<Mirror>() {
                @Override
                public int compare(Mirror o1, Mirror o2) {
                    return o1.x - o2.x;
                }
            }));
            xmap.get(x).add(new Mirror (x, y, dir));
            ymap.get(y).add(new Mirror (x, y, dir));
            mirrors.add(new Mirror (x, y, dir));
        }
        if (simulate(xmap, ymap)){
            pw.println(0);
            pw.close();
            return;
        }
        for (int i=1; i < mirrors.size(); i++){
            count.replaceAll((j, v) -> 0);
            Mirror cur = mirrors.get(i);
            xmap.get(cur.x).remove(cur);
            ymap.get(cur.y).remove(cur);
            xmap.get(cur.x).add(new Mirror (cur.x, cur.y, 1-cur.dir));
            ymap.get(cur.y).add(new Mirror (cur.x, cur.y, 1-cur.dir));
            if (simulate(xmap, ymap)){
                pw.println(i);
                pw.close();
                return;
            }
            xmap.get(cur.x).remove(new Mirror (cur.x, cur.y, 1-cur.dir));
            ymap.get(cur.y).remove(new Mirror (cur.x, cur.y, 1-cur.dir));
            xmap.get(cur.x).add(cur);
            ymap.get(cur.y).add(cur);
        }
        pw.println(-1);
        pw.close();
    }
}
