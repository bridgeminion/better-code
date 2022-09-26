package high_frequency.calculation;

/**
 * set smallest and secondSmallest
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= smallest) {
                smallest = num;
            } else if (num <= secondSmallest) {
                secondSmallest = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence instance = new IncreasingTripletSubsequence();
        int[] nums = {1,1,1,1,1};
        System.out.println(instance.increasingTriplet(nums));
    }

}
