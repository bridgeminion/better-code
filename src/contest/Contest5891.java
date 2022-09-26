package contest;

public class Contest5891 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }
        int total = mean * (n + rolls.length);
        int missing = total - sum;
        int average = missing/n;
        int count = missing - average*n;
        if (average > 6 || (average == 6 && count > 0) || average <= 0 ) {
            return new int[]{};
        }
        int[] result = new int[n];
        int i=0;
        while (i < n-count) {
            result[i++] = average;
        }
        while (i < n) {
            result[i++] = average + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        Contest5891 app = new Contest5891();
        int[] rolls = {6,3,4,3,5,3};
        System.out.println(app.missingRolls(rolls, 1, 6));
    }
}
