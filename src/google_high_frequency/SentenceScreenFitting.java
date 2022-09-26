package google_high_frequency;

public class SentenceScreenFitting {
    public int wordsTyping1(String[] sentence, int rows, int cols) {
        int start = 0, count = 0;
        while (rows > 0) {
            for (int i=0; i<sentence.length && rows > 0; i++) {
                String word = sentence[i];
                if (start + word.length() < cols) {
                    start += word.length() + 1;
                } else if (start + word.length() == cols) {
                    rows--;
                    start = 0;
                } else {
                    rows--;
                    if (rows == 0) {
                        break;
                    }
                    start = word.length() + 1;
                }
                count++;
            }
        }

        return count/sentence.length;
    }

    public int wordsTyping(String[] sentence, int rows, int cols) {
        String sent = String.join(" ", sentence) + " ";
        int pos = 0, len = sent.length();
        for(int i=0; i<rows; i++) {
            pos += cols;
            while(pos >=0 && sent.charAt(pos%len)!=' '){
                pos--;
            }
            pos++;
        }
        return pos / len;
    }

    public static void main(String[] args) {
        SentenceScreenFitting app = new SentenceScreenFitting();
        String[] s = {"a", "bcd", "e"};
        System.out.println(app.wordsTyping(s, 3, 6));
    }
}
