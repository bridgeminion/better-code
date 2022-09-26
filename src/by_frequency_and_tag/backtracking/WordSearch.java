package by_frequency_and_tag.backtracking;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, m, n, word, 0, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int m, int n, String word, int index, boolean[][] visited) {
        System.out.println("calling dfs with i="+i+",j=" + j);
        if (index == word.length()) {
            return true;
        }
        if (i<0 || i>=m || j<0 || j>=n || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
//        if (dfs(board, i+1, j, m, n, word, index+1, visited) ||
//                dfs(board, i-1, j, m, n, word, index+1, visited) ||
//                dfs(board, i, j+1, m, n, word, index+1, visited) ||
//                dfs(board, i, j-1, m, n, word, index+1, visited)) {
//            return true;
//        }
        boolean result = false;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for (int[] dir : dirs) {
            result |= dfs(board, i+dir[0], j+dir[1], m, n, word, index+1, visited);
            if (result) {
                return result;
            }
        }
        visited[i][j] = false;

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        WordSearch app = new WordSearch();
        System.out.println(app.exist(board, "SEE"));
    }

}
