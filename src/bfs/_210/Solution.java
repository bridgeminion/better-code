package bfs._210;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] order = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            int courseNo = queue.poll();
            order[count] = courseNo;
            count++;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == courseNo) {
                    inDegree[prerequisites[i][0]]--;
                    if (inDegree[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        return count == numCourses ? order : new int[]{};
    }

        public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] pre = {{1,0}};
        System.out.println(solution.findOrder(2, pre));
    }

}
