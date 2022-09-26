package cycle_detection._287;

public class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[0], slow = nums[0];
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);
        slow = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return fast;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,4,2,2};
        System.out.println(solution.findDuplicate(nums));
    }

}
