package contest;

public class Contest5760 {
    public int minSwaps(String s) {
        char[] chars = s.toCharArray();
        int oneCount = 0, size = s.length();
        for (char c : chars) {
            if (c == '1') {
                oneCount++;
            }
        }
        if (size % 2 == 0) {
            if (oneCount != size/2) {
                return -1;
            }
        } else {
            if (Math.abs(oneCount - (size - oneCount)) > 1) {
                return -1;
            }
        }
        int count1 = 0, count2 = 0;
        if (size % 2 == 1) {
            if (oneCount > size/2) {
                for (int i=0; i<size; i++) {
                    if (chars[i] != (i%2 == 0 ? '1' : '0')) {
                        count1++;
                    }
                }
            } else {
                for (int i=0; i<size; i++) {
                    if (chars[i] != (i%2 == 0 ? '0' : '1')) {
                        count1++;
                    }
                }
            }
            return count1/2;
        } else {
            for (int i=0; i<size; i++) {
                if (chars[i] != (i%2 == 0 ? '1' : '0')) {
                    count1++;
                }
            }
            for (int i=0; i<size; i++) {
                if (chars[i] != (i%2 == 0 ? '0' : '1')) {
                    count2++;
                }
            }
            return Math.min(count1, count2)/2;
        }
     }

    public static void main(String[] args) {
        Contest5760 instance = new Contest5760();
        System.out.println(instance.minSwaps("100"));
    }

}
