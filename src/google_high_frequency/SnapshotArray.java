package google_high_frequency;

import java.util.*;

public class SnapshotArray {
    TreeMap<Integer, Integer>[] list;
    int snapId = 0;
    public SnapshotArray (int length) {
        list = new TreeMap[length];
        for (int i=0; i<length; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            map.put(0, 0);
            list[i] = map;
        }
    }

    public void set (int index, int val) {
        TreeMap<Integer, Integer> map = list[index];
        map.put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> map = list[index];
        return map.floorEntry(snap_id).getValue();
    }

    public static void main(String[] args) {
        SnapshotArray app = new SnapshotArray(3);
        app.set(0, 5);
        System.out.println(app.snap());
        app.set(0,6);
        System.out.println(app.get(0,0));

    }
}
