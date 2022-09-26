package top_interview_questions;

public class NumberOfIslands {
    public int numIslandsDFS(char[][] grid) {
        int r = grid.length, c = grid[0].length;
        int count = 0;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, r, c);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '*' || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '*';
        int[][] moves = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for (int[] move : moves) {
            dfs(grid, i+move[0], j+move[1], row, col);
        }
    }

    public static void main(String[] args) {
        NumberOfIslands instance = new NumberOfIslands();
        char[][] grid = {
                          {'1','1','1','1','0'},
                          {'1','1','0','1','0'},
                          {'1','1','0','0','0'},
                          {'0','0','0','0','0'}
                        };
        System.out.println(instance.numIslands(grid));
    }

    class UnionFind {
        int count;
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            this.count = n;
            parent = new int[n+1];
            size = new int[n+1];
            for (int i = 0; i<=n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            return parent[i] == i ? i : find(parent[i]);
        }

        public void union(int i, int j) {
            int root1 = find(i);
            int root2 = find(j);
            if (root1 != root2) {
                if (size[root1] > size[root2]) {
                    parent[root2] = root1;
                    size[root1] += size[root2];
                } else {
                    parent[root1] = root2;
                    size[root2] += size[root1];
                }
                count--;
            }
         }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        UnionFind unionFind = new UnionFind(rows*cols);
        int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int zeroes = 0;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (grid[i][j] == '0') {
                    zeroes++;
                } else {
                    for (int[] move : moves) {
                        int newX = i + move[0];
                        int newY = j + move[1];
                        if (newX >=0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == '1') {
                            unionFind.union(i*cols+j, newX*cols+newY);
                        }
                    }
                }
            }
        }

        return unionFind.count - zeroes;
    }

}
