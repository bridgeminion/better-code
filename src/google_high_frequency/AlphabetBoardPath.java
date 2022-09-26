package google_high_frequency;

public class AlphabetBoardPath {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int prevRow = 0, prevCol = 0;
        for (int i=0; i<target.length(); i++) {
            int to = target.charAt(i) - 'a';
            int row = to/5, col = to%5;
            append(prevRow, row, prevCol, col, sb);
            prevRow = row;
            prevCol = col;
        }

        return sb.toString();
    }

    private void append(int prevRow, int row, int prevCol, int col, StringBuilder sb) {
        while (prevRow > row) {
            sb.append("U");
            prevRow--;
        }
        while (prevCol < col) {
            sb.append("R");
            prevCol++;
        }
        while (prevCol > col) {
            sb.append("L");
            prevCol--;
        }
        while (prevRow < row) {
            sb.append("D");
            prevRow++;
        }
        sb.append("!");
    }

    public static void main(String[] args) {
        AlphabetBoardPath app = new AlphabetBoardPath();
        System.out.println(app.alphabetBoardPath("zdz"));
    }

}
