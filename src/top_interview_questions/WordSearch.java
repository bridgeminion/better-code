package top_interview_questions;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int r = board.length, c = board[0].length;
        int[][] visited = new int[r][c];
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, i, j, word, 0, visited, r, c)) {
                        return true;
                    }
                }
            }
        }

        return false;

    }

    private boolean helper(char[][] board, int i, int j, String word, int index, int[][] visited, int r, int c) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= r || j < 0 || j >= c || visited[i][j] == 1 || word.charAt(index) != board[i][j]) {
            return false;
        }
        visited[i][j] = 1;
        int[][] moves = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for (int[] move : moves) {
            int newRow = i + move[0];
            int newCol = j + move[1];
            if (helper(board, newRow, newCol, word, index+1, visited, r, c)) {
                return true;
            }
        }
        visited[i][j] = 0;

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        WordSearch instance = new WordSearch();
        System.out.println(instance.exist(board, "ABCESEEEFS"));
    }

}
