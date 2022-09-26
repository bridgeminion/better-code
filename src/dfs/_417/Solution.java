package dfs._417;

import common.TreeNode;

import java.util.*;

/**
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean.
 * The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 *
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights
 * where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 *
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west
 * if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 *
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow
 * from cell (ri, ci) to both the Pacific and Atlantic oceans.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * Example 2:
 *
 * Input: heights = [[2,1],[1,2]]
 * Output: [[0,0],[0,1],[1,0],[1,1]]
 */
public class Solution {
    int[][] moves = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0] == null || heights[0].length == 0) {
            return result;
        }
        int[][] pacific = new int[heights.length][heights[0].length];
        int[][] atlantic = new int[heights.length][heights[0].length];
        int[][] visited;

        for (int i=0; i<heights.length; i++) {
            for (int j=0; j<heights[0].length; j++) {
                visited = new int[heights.length][heights[0].length];
                dfs(heights, visited, pacific, atlantic, i, j, i, j);
            }
        }
        for (int i=0; i<heights.length; i++) {
            for (int j=0; j<heights[0].length; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int[][] visited, int[][] pacific, int[][] atlantic, int i, int j, int row, int col) {
        if (i == 0 || j == 0) {
            pacific[row][col] = 1;
        }
        if (i == heights.length - 1 || j == heights[0].length - 1) {
            atlantic[row][col] = 1;
        }
        visited[i][j] = 1;
        for (int[] move : moves) {
            int nextX = i + move[0];
            int nextY = j + move[1];
            if (nextX >= 0 && nextX < heights.length && nextY >= 0 && nextY < heights[0].length && visited[nextX][nextY] == 0) {
                if(heights[i][j] >= heights[nextX][nextY]) {
                    dfs(heights, visited, pacific, atlantic, nextX, nextY, row, col);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] heights ={{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> result = solution.pacificAtlanticBFS(heights);
    }

    public List<List<Integer>> pacificAtlanticBFS(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0] == null || heights[0].length == 0) {
            return result;
        }
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacificVisited = new boolean[m][n];
        boolean[][] atlanticVisited = new boolean[m][n];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        for (int i=0; i<m; i++) {
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, n-1});
        }
        for (int i=0; i<n; i++) {
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{m-1, i});
        }
        while (!pQueue.isEmpty()) {
            int[] cell = pQueue.poll();
            pacificVisited[cell[0]][cell[1]] = true;
            for (int[] move : moves) {
                int nextX = cell[0] + move[0];
                int nextY = cell[1] + move[1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !pacificVisited[nextX][nextY] && heights[cell[0]][cell[1]] <= heights[nextX][nextY]) {
                    pQueue.offer(new int[]{nextX, nextY});
                }
            }
        }
        while (!aQueue.isEmpty()) {
            int[] cell = aQueue.poll();
            atlanticVisited[cell[0]][cell[1]] = true;
            for (int[] move : moves) {
                int nextX = cell[0] + move[0];
                int nextY = cell[1] + move[1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !atlanticVisited[nextX][nextY] && heights[cell[0]][cell[1]] <= heights[nextX][nextY]) {
                    aQueue.offer(new int[]{nextX, nextY});
                }
            }
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }

        return result;
    }

}
