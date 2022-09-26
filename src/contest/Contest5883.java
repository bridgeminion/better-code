package contest;

public class Contest5883 {
    public boolean placeWordInCrossword(char[][] board, String word) {
        int r = board.length, c = board[0].length;
        boolean notValid = false;
        int k;
        for (int i=0; i<r; i++) {
            k = 0;
            for (int j=0; j<c; j++) {
                if (board[i][j] == '#') {
                    if (k == word.length()) {
                        return true;
                    }
                    k = 0;
                } else if (board[i][j] == ' ' || (k < word.length() && board[i][j] == word.charAt(k))) {
                    if (k < word.length()) {
                        k++;
                    } else {
                        notValid = true;
                        break;
                    }
                } else {
                    k = 0;
                }
            }
            if (!notValid && k == word.length()) {
                return true;
            }
            k = 0;
            notValid = false;
            for (int j=c-1; j>=0; j--) {
                if (board[i][j] == '#') {
                    if (k == word.length()) {
                        return true;
                    }
                    k = 0;
                } else if (board[i][j] == ' ' || (k < word.length() && board[i][j] == word.charAt(k))) {
                    if (k < word.length()) {
                        k++;
                    } else {
                        notValid = true;
                        break;
                    }
                } else {
                    k = 0;
                }
            }
            if (!notValid && k == word.length()) {
                return true;
            }
        }

        for (int i=0; i<c; i++) {
            k = 0;
            notValid = false;
            for (int j=0; j<r; j++) {
                if (board[j][i] == '#') {
                    if (k == word.length()) {
                        return true;
                    }
                    k = 0;
                } else if (board[j][i] == ' ' || (k < word.length() && board[j][i] == word.charAt(k))) {
                    if (k < word.length()) {
                        k++;
                    } else {
                        notValid = true;
                        break;
                    }
                } else {
                    k = 0;
                }
            }
            if (!notValid && k == word.length()) {
                return true;
            }
            k = 0;
            notValid = false;
            for (int j=r-1; j>=0; j--) {
                if (board[j][i] == '#') {
                    if (k == word.length()) {
                        return true;
                    }
                    k = 0;
                } else if (board[j][i] == ' ' || (k < word.length() && board[j][i] == word.charAt(k))) {
                    if (k < word.length()) {
                        k++;
                    } else {
                        notValid = true;
                        break;
                    }
                } else {
                    k = 0;
                }
            }
            if (!notValid && k == word.length()) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Contest5883 instance = new Contest5883();
//        char[][] board = {{'i',' ','#',' ',' ','o','c',' '}};
        char[][] board = {{' ', '#', 'a'}, {' ', '#', 'c'}, {' ', '#', 'a'}};
        System.out.println(instance.placeWordInCrossword(board, "ac"));
    }
}
