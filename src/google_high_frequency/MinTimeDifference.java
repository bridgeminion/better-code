package google_high_frequency;

import java.util.Arrays;
import java.util.List;

public class MinTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int[] times = new int[2880];
        for (String tp : timePoints) {
            String[] tokens = tp.split(":");
            if ("00".equals(tokens[0])) {

                int t1 = Integer.valueOf(tokens[1]);
                int t2 = 24 * 60 + Integer.valueOf(tokens[1]);

                times[t1]++;
                times[t2]++;
                if (times[t1] > 1 || times[t2] > 1) {
                    return 0;
                }
            } else {
                int time = Integer.valueOf(tokens[0]) * 60 + Integer.valueOf(tokens[1]);
                times[time]++;
                if (times[time] > 1) {
                    return 0;
                }
            }
        }
        int prev = -1, min = Integer.MAX_VALUE;
        for (int i=0; i<2880; i++) {
            if (times[i] >= 1) {
                if (prev == -1) {
                    prev = i;
                } else {
                    min = Math.min(min, i - prev);
                    prev = i;
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        MinTimeDifference app = new MinTimeDifference();
        List<String> times = Arrays.asList("01:39","10:26","21:43");
        System.out.println(app.findMinDifference(times));
    }
}
