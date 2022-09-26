package daily_contest;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> ladderSet = new PriorityQueue<>();
        int brickUsed = 0;
        for(int i=1; i<heights.length; i++) {
            int gap = heights[i] - heights[i-1];
            if (gap > 0) {
                ladderSet.add(gap);
                if (ladderSet.size() > ladders) {
                    int out = ladderSet.poll();
                    brickUsed += out;
                }
                if (brickUsed > bricks) {
                    return i-1;
                }
            }
        }
        return heights.length - 1;
    }

    public static void main(String[] args) {
        FurthestBuildingYouCanReach instance = new FurthestBuildingYouCanReach();
        int[] heights = {4,2,7,6,9,14,12};
        System.out.println(instance.furthestBuilding(heights, 5, 1));
    }

}
