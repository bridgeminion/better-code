package by_frequency_and_tag.binary_search;

import java.util.Map;
import java.util.TreeMap;

public class HitCounter {
    TreeMap<Integer, Integer> countMap = new TreeMap<>();

    public HitCounter() {

    }

    public void hit(int timestamp) {
        countMap.put(timestamp, countMap.getOrDefault(timestamp, 0) + 1);
    }

    public int getHits(int timestamp) {
        Map<Integer, Integer> subMap = countMap.subMap(timestamp-299, timestamp+1);
        return subMap.values().stream().mapToInt(Integer::intValue).sum();
    }

}
