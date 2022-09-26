
package graph._1494;

import java.io.IOException;
import java.util.*;

public class Solution {

    public static boolean works (int x, int y) {
        while (x > 0 || y > 0) {
            if ((x % 3) % 2 != (y % 3) % 2) {
                return false;
            }
            x /= 3;
            y /= 3;
        }

        return true;

    }

    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        int x1=4, y1=0, x2=0, y2=5;
        Set<Pair> visited = new HashSet<>();
        Set<Integer> set = new TreeSet<>();
        set.add(x1);
        set.add(y1);
        set.add(x2);
        set.add(y2);
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x1, y1));
        queue.offer(new Pair(x2, y2));
        while (!queue.isEmpty()) {
            Pair first = queue.poll();
            Pair second = queue.poll();
            visited.add(first);
            visited.add(second);
            set.add(first.x);
            set.add(first.y);
            set.add(second.x);
            set.add(second.y);
            for (Integer s : set) {
                for (Integer t : set) {
                    int nextX1 = x1 + s;
                    int nextY1 = y1 + t;
                    int nextX2 = x1 + t;
                    int nexty2 = y1 + s;
                    int nextX3 = x2 + s;
                    int nextY3 = y2 + t;
                    int nextX4 = x2 + t;
                    int nexty4 = y2 + s;
                    if (!visited.contains(new Pair(nextX1, nextY1))) {
                        queue.offer(new Pair(nextX1, nextY1));
                    }

                }
            }

        }


    }
}
