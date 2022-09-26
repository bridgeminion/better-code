package google_high_frequency;

public class MaxAreaOfIsland {
    class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind (int n) {
            parent = new int[n];
            size = new int[n];
            for (int i=0; i<n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int key) {
            if (parent[key] == key) {
                return key;
            }
            return find(parent[key]);
        }

        public boolean union(int a, int b) {
            int parent1 = find(a);
            int parent2 = find(b);
            if (parent1 == parent2) {
                return false;
            }
            if (size[parent1] > size[parent2]) {
                parent[parent2] = parent1;
                size[parent1] += size[parent2];
            } else {
                parent[parent1] = parent2;
                size[parent2] += size[parent1];
            }

            return true;
        }

        public int getClusterSize(int a)  {
            int root = find(a);
            return size[root];
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(m*n);
        int max = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    helper(grid, i, j, uf, visited, m, n);
                    max = Math.max(max, uf.getClusterSize(i*n+j));
                }
            }
        }

        return max;
    }

    private void helper(int[][] grid, int i, int j, UnionFind uf, boolean[][] visited, int m, int n) {
        int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for (int[] move : moves) {
            int nextX = i + move[0];
            int nextY = j + move[1];
            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                uf.union(i*n+j, nextX*n+nextY);
                visited[nextX][nextY] = true;
                helper(grid, nextX, nextY, uf, visited, m, n);
            }
        }
    }

    public static void main(String[] args) {
        MaxAreaOfIsland app = new MaxAreaOfIsland();
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(app.maxAreaOfIsland(grid));
    }
}
