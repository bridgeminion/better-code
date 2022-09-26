package google_high_frequency;

public class MaxPointsCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int max = Integer.MIN_VALUE;
        int m = cardPoints.length;
        int[] left = new int[k+1], right = new int[k+1];
        for (int i=1; i<=k; i++) {
            left[i] = left[i-1] + cardPoints[i-1];
        }
        for (int i=1; i<=k; i++) {
            right[i] = right[i-1] + cardPoints[m-i];
        }
        for (int i=0; i<=k; i++) {
            max = Math.max(max, left[i] + right[k-i]);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxPointsCanObtainFromCards app = new MaxPointsCanObtainFromCards();
        int[] cards = {1,2,3,4,5,6,1};
        System.out.println(app.maxScore(cards, 3));
    }
}
