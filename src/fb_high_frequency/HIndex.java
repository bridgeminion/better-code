package fb_high_frequency;

public class HIndex {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] count = new int[len + 1];

        for (int c: citations)
            if (c > len)
                count[len]++;
            else
                count[c]++;


        int total = 0;
        for (int i = len; i >= 0; i--) {
            total += count[i];
            if (total >= i)
                return i;
        }

        return 0;
    }

    public static void main(String[] args) {
        HIndex app = new HIndex();
        int[] citations = {3,0,6,1,5};
        System.out.println(app.hIndex(citations));
    }
}
