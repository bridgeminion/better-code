package daily_challenge;

import java.util.*;

public class CourseScheduleThree {
    int max = 0;
    public int scheduleCourseDFS(int[][] courses) {
        helper(courses, 0, new HashSet<>());

        return max;
    }

    private void helper(int[][] courses, int lastDay, Set<Integer> set) {
        for(int i=0; i<courses.length; i++) {
            if (!set.contains(i)) {
                if (lastDay + courses[i][0] <= courses[i][1]) {
                    set.add(i);
                    max = Math.max(max, set.size());
                    helper(courses, lastDay + courses[i][0], set);
                    set.remove(i);
                } else {
                    max = Math.max(max, set.size());
                }
            }
        }
    }

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (i1, i2) -> i1[1] - i2[1]);
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int duration = 0;
        for (int[] course : courses) {
            duration += course[0];
            pq.offer(course[0]);
            if (duration > course[1]) {
                duration -= pq.poll();
            }
        }

        return pq.size();
    }

    public static void main(String[] args) {
        CourseScheduleThree instance = new CourseScheduleThree();
        int[][] courses = {{5,5}, {4,6}, {2,6}};
        System.out.println(instance.scheduleCourse(courses));
    }

}
