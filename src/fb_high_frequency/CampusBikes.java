package fb_high_frequency;

import java.util.*;

public class CampusBikes {
    class Pair {
        int w;
        int b;
        public Pair (int w, int b) {
            this.w = w;
            this.b = b;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Pair pair = (Pair) o;
//            return w == pair.w && b == pair.b;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(w, b);
//        }
    }
    public int[] assignBikesPriorityQueue(int[][] workers, int[][] bikes) {
        // write your code here
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b)-> {
            int distance1 = distance(workers[a.w], bikes[a.b]);
            int distance2 = distance(workers[b.w], bikes[b.b]);
            return distance1 == distance2 ? a.w == b.w ? a.b - b.b : a.w - b.w : distance1 - distance2;
        });
        for (int i=0; i<workers.length; i++) {
            for (int j=0; j<bikes.length; j++) {
                queue.offer(new Pair(i, j));
            }
        }
        int[] result = new int[workers.length];
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            result[pair.w] = pair.b;
            for (int i=0; i<workers.length; i++) {
                queue.remove(new Pair(i, pair.b));
            }
            for (int i=0; i<bikes.length; i++) {
                queue.remove(new Pair(pair.w, i));
            }
        }

        return result;
    }

    public int[] assignBikesTreeSet(int[][] workers, int[][] bikes) {
        // write your code here
        TreeSet<Pair> set = new TreeSet<>((a, b)-> {
            int distance1 = distance(workers[a.w], bikes[a.b]);
            int distance2 = distance(workers[b.w], bikes[b.b]);
            return distance1 == distance2 ? a.w == b.w ? a.b - b.b : a.w - b.w : distance1 - distance2;
        });
        for (int i=0; i<workers.length; i++) {
            for (int j=0; j<bikes.length; j++) {
                set.add(new Pair(i, j));
            }
        }
        int[] result = new int[workers.length];
        while (!set.isEmpty()) {
            Pair pair = set.pollFirst();
            result[pair.w] = pair.b;
            for (int i=0; i<workers.length; i++) {
                set.remove(new Pair(i, pair.b));
            }
            for (int i=0; i<bikes.length; i++) {
                set.remove(new Pair(pair.w, i));
            }
        }

        return result;
    }

    private int distance(int[] worker, int[] bike) {
        return Math.abs(worker[0]-bike[0]) + Math.abs(worker[1]-bike[1]);
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<int[]>[] list = new List[2001];
        for (int i=0; i<workers.length; i++) {
            for (int j=0; j<bikes.length; j++) {
                int distance = distance(workers[i], bikes[j]);
                List<int[]> pairs = list[distance];
                if (pairs == null) {
                    list[distance] = new ArrayList<>();
                }
                list[distance].add(new int[] {i, j});
            }
        }
        int[] result = new int[workers.length];
        Set<Integer> assignedWorkers = new HashSet<>();
        Set<Integer> assignedBikes = new HashSet<>();
        for (int i=0; i<list.length; i++) {
             if (list[i] != null) {
               for (int j=0; j<list[i].size(); j++) {
                    int[] pair = list[i].get(j);
                    if (!assignedWorkers.contains(pair[0]) && !assignedBikes.contains(pair[1])) {
                        assignedWorkers.add(pair[0]);
                        result[pair[0]] = pair[1];
                        assignedBikes.add(pair[1]);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CampusBikes app = new CampusBikes();
        int[][] workers = new int[][]{{0,0},{1,1},{2,0}};
        int[][] bikes = new int[][]{{1,0},{2,2},{2,1}};
        app.assignBikes(workers, bikes);
    }

}
