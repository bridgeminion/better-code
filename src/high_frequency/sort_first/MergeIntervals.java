package high_frequency.sort_first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int lastEnd = intervals[0][1];
        for (int i=1; i<intervals.length; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            if (start > lastEnd) {
                result.add(intervals[i]);
                lastEnd = end;
            } else {
                if (end > lastEnd) {
                    result.get(result.size() - 1)[1] = end;
                    lastEnd = end;
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals instance = new MergeIntervals();
//        int[][] intervals = {{1,3}, {2,6}, {8,10}, {9,9}, {15,18}};
        int[][] intervals = {{1,3}, {0,3}, {8,10}, {9,9}, {15,18}};
        instance.merge(intervals);
    }

}
