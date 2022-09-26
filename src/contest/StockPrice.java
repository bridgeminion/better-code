package contest;

import java.util.*;

public class StockPrice {
        class Entry {
                int ts;
                int price;
                public Entry(int ts, int price) {
                        this.ts = ts;
                        this.price = price;
                }
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        TreeSet<Entry> set = new TreeSet<>((e1, e2) ->  e1.price == e2.price ? e1.ts - e2.ts : e1.price - e2.price );

        public StockPrice() {

        }

        public void update(int timestamp, int price) {
                if (map.containsKey(timestamp)) {
                        int oldPrice = map.get(timestamp);
                        if (oldPrice != price) {
                                set.remove(new Entry(timestamp, oldPrice));
                                set.add(new Entry(timestamp, price));
                                map.put(timestamp, price);
                        }
                } else {
                        set.add(new Entry(timestamp, price));
                        map.put(timestamp, price);
                }
        }

        public int current() {
                return map.lastEntry().getValue();
        }

        public int maximum() {
                return set.last().price;

        }

        public int minimum() {
                return set.first().price;

        }
}
