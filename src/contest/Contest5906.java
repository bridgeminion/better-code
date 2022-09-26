package contest;

import java.util.regex.Pattern;

public class Contest5906 {
    public int countValidWords(String sentence) {
        String[] words = sentence.split(" ");
        int count = 0;
        for (String word : words) {
            if (!"".equals(word)) {
                String pattern = "";
                if (word.indexOf("-") != -1) {
                    pattern = "^[a-z]+-[a-z]+[!|\\.|,]?";
                } else {
                    pattern = "^[a-z]*[!|\\.|,]?$";
                }
                if (word.matches(pattern)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Contest5906 app = new Contest5906();
        System.out.println(app.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
    }

}
