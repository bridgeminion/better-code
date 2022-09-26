package abnb;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int left = 1, right = max;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (isValid(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isValid(int[] piles, int h, int k) {
        int count = 0;
        for (int pile : piles) {
            count += pile%k == 0 ? pile/k : pile/k + 1;
        }

        return count <= h;
    }

    public static void main(String[] args) {
        KokoEatingBananas app = new KokoEatingBananas();
        int[] piles = {30,11,23,4,20};
        System.out.println(app.minEatingSpeed(piles, 6));
    }
}
