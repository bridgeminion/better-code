package top_interview_questions;

import java.util.*;

/**
 * when remove two cases:
 * if removing last element, just remove from list and map
 * otherwise, swap with last element and update value for last element
 */
public class RandomizedSet {
    Random random;
    Map<Integer, Integer> map;
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        random = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int indexToRemove = map.get(val);
        if (indexToRemove != list.size() - 1) {
            list.set(indexToRemove, list.get(list.size()-1));
            map.put(list.get(indexToRemove), indexToRemove);
        }
        list.remove(list.size()-1);
        map.remove(val);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet instance = new RandomizedSet();
        instance.insert(-1);
        instance.remove(-2);
        instance.insert(-2);
        instance.getRandom();
        instance.remove(-1);
        instance.insert(-2);
        instance.getRandom();

    }

}
