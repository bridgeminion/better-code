package fb_high_frequency;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length-1;
        int target = nums.length - k;
        while (left <= right) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }

        return -1;
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = start, tmp;
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot]) start++;
            while (start <= end && nums[end] > nums[pivot]) end--;
            if (start > end) {
                break;
            }
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }
        tmp = nums[end];
        nums[end] = nums[pivot];
        nums[pivot] = tmp;

        return end;
    }

    public static void main(String[] args) {
        KthLargestElement app = new KthLargestElement();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(app.findKthLargest(nums, 2));
    }
}
