package by_frequency_and_tag.dijkstra;

import java.util.*;

public class CheapestFlightsWithinKStops {
    class Pair {
        int city;
        int price;
        int stops;
        public Pair (int city, int price, int stops) {
            this.city = city;
            this.price = price;
            this.stops = stops;
        }
        public Pair (int city, int price) {
            this.city = city;
            this.price = price;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Pair>> map = new HashMap<>();
        Map<Integer, Integer> stopMap = new HashMap<>();
        for (int[] flight : flights) {
            map.putIfAbsent(flight[0], new ArrayList<>());
            map.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.price, b.price));
        pq.offer(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            if (stopMap.containsKey(pair.city) && stopMap.get(pair.city) < pair.stops) {
                continue;
            }
            stopMap.put(pair.city, pair.stops);
            if (pair.city == dst && pair.stops-1 <= k) {
                return pair.price;
            }
            if (pair.stops > k) {
                continue;
            }
            int city = pair.city, price = pair.price, stops = pair.stops;
            if (map.containsKey(city)) {
                for (Pair p : map.get(city)) {
                    pq.offer(new Pair(p.city, price + p.price, stops+1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops app = new CheapestFlightsWithinKStops();
        int[][] flights = {{0,3,59},{2,0,83},{2,3,32},{0,2,97},{3,1,16},{1,3,16}};
        System.out.println(app.findCheapestPrice(4, flights, 3, 0, 3));
    }
}
