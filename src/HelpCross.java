// Arup Guha
// 2/22/2017
// Main to 2017 February USACO Silver Problem: Why Did the Cow Cross the Road? (helpcross)

import java.util.*;
import java.io.*;

public class HelpCross {

    public static void main(String[] args) throws Exception {

        // Read input.
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int m = stdin.nextInt();

        animal[] all = new animal[m+n];

        // Read in chickens first.
        for (int i=0; i<n; i++) {
            int t = stdin.nextInt();
            all[i] = new animal(t, t, false);
        }

        // Then cows.
        for (int i=n; i<n+m; i++) {
            int s = stdin.nextInt();
            int e = stdin.nextInt();
            all[i] = new animal(s, e, true);
        }

        // Sort all.
        Arrays.sort(all);

        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // Go through all animal's start times.
        for (int i=0; i<all.length; i++) {

            // If it's a cow, add it to our list of cows waiting to get help from chickens.
            if (all[i].isCow)
                pq.offer(all[i].end);

                // We get a chicken!
            else {

                // Get rid of cows who are no longer avaiable.
                while (pq.size() > 0 && pq.peek() < all[i].start) pq.poll();

                // This chicken can help a cow!
                if (pq.size() > 0) {
                    res++;

                    // We greedily remove the cow who is available the least.
                    pq.poll();
                }

            }
        }

        // Output the result.
        PrintWriter out = new PrintWriter(System.out);
        out.println(res);
        out.close();
        stdin.close();
    }
}

class animal implements Comparable<animal> {
    public int start;
    public int end;
    public boolean isCow;

    public animal(int s, int e, boolean b) {
        start = s;
        end = e;
        isCow = b;
    }

    public int compareTo(animal other) {
        if (this.start != other.start)
            return this.start - other.start;
        if (this.isCow && !other.isCow) return -1;
        if (!this.isCow && other.isCow) return 1;
        return 0;
    }

    public static class TreeSetWithDuplicate<T extends Comparable<T>> {
        private final TreeMap<T, Integer> map;

        public TreeSetWithDuplicate() {
            map = new TreeMap<>();
        }

        public T floorKey(T t) {
            return map.floorKey(t);
        }

        public T ceilingKey(T t) {
            return map.ceilingKey(t);
        }

        public void remove(T t) {
            if (map.get(t) == 1) {
                map.remove(t);
            } else {
                map.put(t, map.get(t) - 1);
            }
        }

        public void insert(T t) {
            map.putIfAbsent(t, 0);
            map.put(t, map.get(t) + 1);
        }

    }
}
