package fb_high_frequency;

/**
 * 1. -- first, 1 based, 1 -> A become 0 -> A, then we can do num % 26 + 'A'
 * cast int to (char) to get char
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            sb.insert(0, (char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle app = new ExcelSheetColumnTitle();
        System.out.println(app.convertToTitle(701));
    }

}
