package contest;

import java.util.Arrays;

public class Contest2171 {
    public long minimumRemoval(int[] beans) {
        int m = beans.length;
        Arrays.sort(beans);
        long sum = 0;
        for (int i=0; i<m; i++) {
            sum += beans[i] - beans[0];
        }
        long min = sum;
        long nextSum = 0;
        for (int i=1; i<m; i++) {
            if (beans[i] != beans[0]) {
                nextSum = sum - (m-i)*(beans[i]-beans[0]) + beans[0]*(i-0);
                min = Math.min(min, nextSum);
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Contest2171 app = new Contest2171();
        int[] beans = {2,10,3,2};
        System.out.println(app.minimumRemoval(beans));
    }
}
