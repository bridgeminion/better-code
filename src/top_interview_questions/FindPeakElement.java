package top_interview_questions;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid-1] < nums[mid]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return nums[left] > nums[right] ? left : right;
    }


    public static void main(String[] args) {
        FindPeakElement instance = new FindPeakElement();
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(instance.findPeakElement(nums));
    }

}
