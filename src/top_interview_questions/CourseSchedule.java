package top_interview_questions;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int canFinish = 0;
        for (int i=0; i<inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                canFinish++;
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == course) {
                    inDegree[prerequisite[0]]--;
                    if (inDegree[prerequisite[0]] == 0) {
                        queue.offer(prerequisite[0]);
                        canFinish++;
                    }
                }
            }
        }

        return canFinish == numCourses;
    }

}
