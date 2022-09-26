package linkedIn_high_frequency;

import java.util.*;

public class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);

        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int last = list.get(list.size()-1);
        list.set(map.get(val), last);
        list.remove(list.size()-1);
        map.put(last, map.get(val));
        map.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet app = new RandomizedSet();
        app.insert(0);
        app.insert(1);
        app.remove(0);
        app.insert(2);
        app.remove(1);
        System.out.println(app.getRandom());
    }
}
