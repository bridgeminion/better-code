package top_interview_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * either update end of existing interval
 * or add new interval
 * no need to keep track of prevEnd, get from last element in the list
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            int prevEnd = list.isEmpty() ? Integer.MIN_VALUE : list.get(list.size() - 1)[1];
            if (interval[0] <= prevEnd) {
                if (interval[1] > prevEnd) {
                    list.get(list.size() - 1)[1] = interval[1];
                }
            } else {
                list.add(interval);
            }
        }

        return list.toArray(new int[list.size()][]); // convert list<int[]> to int[][]
    }

    public static void main(String[] args) {
        MergeIntervals instance = new MergeIntervals();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(instance.merge(intervals));
    }
}
