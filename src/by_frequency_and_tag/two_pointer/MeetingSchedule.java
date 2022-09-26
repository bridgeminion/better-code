package by_frequency_and_tag.two_pointer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingSchedule {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for (int[] s : slots1)
            if (s[1] - s[0] >= duration)
                pq.offer(s);
        for (int[] s : slots2)
            if (s[1] - s[0] >= duration)
                pq.offer(s);
        while (pq.size() > 1)
            if (pq.poll()[1] >= pq.peek()[0] + duration)
                return Arrays.asList(pq.peek()[0], pq.peek()[0] + duration);
        return Arrays.asList();
    }

    public static void main(String[] args) {
        MeetingSchedule app = new MeetingSchedule();
        int[][] slots1 = {{1,100}};
        int[][] slots2 = {{2,9}, {11,19}};
        app.minAvailableDuration(slots1, slots2, 8);
    }
}
