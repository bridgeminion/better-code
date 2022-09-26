package by_frequency_and_tag.binary_search;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0, min = Integer.MAX_VALUE;
        for (int w : weights) {
            sum += w;
            min = Math.min(min, w);
        }
        int left = min, right = sum;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (isValid(weights, mid, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isValid(int[] weights, int capacity, int days) {
        int count = 1, sum = 0;
        for (int w : weights) {
            if (w > capacity) {
                return false;
            }
            sum += w;
            if (sum > capacity) {
                sum = w;
                count++;
            }
            if (count > days) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays app = new CapacityToShipPackagesWithinDDays();
        int[] weights = {1,2,3,1,1};
        System.out.println(app.shipWithinDays(weights, 4));
    }
}
