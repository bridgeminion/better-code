package bfs._207;

import common.TreeNode;

import java.util.*;

public class Solution {
    public boolean canFinishWithMatrix(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[][] matrix = new int[numCourses][numCourses];
        for (int i=0; i<prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            inDegree[course]++;
            matrix[course][pre] = 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int courseNo = queue.poll();
            for (int i=0; i<numCourses; i++) {
                if (matrix[i][courseNo] == 1) {
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }

        return count == numCourses;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        int count = queue.size();
        while (!queue.isEmpty()) {
            int courseNo = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == courseNo) {
                    inDegree[prerequisites[i][0]]--;
                    if (inDegree[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);
                        count++;
                    }
                }
            }
        }

        return count == numCourses;
    }

        public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] pre = {{1,0}};
        System.out.println(solution.canFinish(2, pre));
    }

}
