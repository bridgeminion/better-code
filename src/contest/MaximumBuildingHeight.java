package contest;

import java.util.*;

public class MaximumBuildingHeight {
    static class Building {
        int pos;
        int height;

        public Building (int pos, int height) {
            this.pos = pos;
            this.height = height;
        }
    }
    public int maxBuilding(int n, int[][] restrictions) {
        List<Building> buildingList = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 0);
        if (restrictions.length == 0) {
            return n-1;
        }
        boolean reached = false;
        for (int[] restriction : restrictions) {
            buildingList.add(new Building(restriction[0], restriction[1]));
            if (restriction[0] == n) {
                reached = true;
            }
        }
        if (!reached) {
            buildingList.add(new Building(n, n-1));
        }
        Collections.sort(buildingList, (a, b) -> {
            if (a.height == b.height) {
                return a.pos - b.pos;
            }
            return a.height - b.height;
        });
        for (Building building : buildingList) {
            Map.Entry<Integer, Integer> left = map.lowerEntry(building.pos);
            Map.Entry<Integer, Integer> right = map.higherEntry(building.pos);
            if (left != null) {
                if ((left.getValue() + building.pos - left.getKey()) < building.height) {
                    building.height = left.getValue() + building.pos - left.getKey();
                }
            }
            if (right != null) {
                if ((right.getValue() + right.getKey() - building.pos) < building.height) {
                    building.height = right.getValue() + right.getKey() - building.pos;
                }
            }
            map.put(building.pos, building.height);
        }
        int max = 0;
        Collections.sort(buildingList, (a, b) -> a.pos - b.pos);
        for (int i=1; i<buildingList.size(); i++) {
            Building l = buildingList.get(i-1);
            Building r = buildingList.get(i);
            max = Math.max(max, Math.max(l.height, r.height) + Math.max(0, ((r.pos-l.pos)-Math.abs(l.height-r.height))/2));
//            max = Math.max(max, (b2.pos - b1.pos + b2.height + b1.height)/2);
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumBuildingHeight instance = new MaximumBuildingHeight();
//        int[][] res = {{5,3},{2,5},{7,4},{10,3}};
        int[][] res = {{2,1},{4,1}};
        System.out.println(instance.maxBuilding(10, res));
    }

}
