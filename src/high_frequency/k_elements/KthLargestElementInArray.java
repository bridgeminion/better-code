package high_frequency.k_elements;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        return partition(nums, 0, nums.length-1, nums.length - k);

    }

    private int partition(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[k];
        }

        int left = start, right = end;
        int pivot = nums[(start + end) / 2];

        while (left <= right) {
            while (left <= right && nums[left] <= pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        if (k <= right) {
            return partition(nums, start, right, k);
        }
        if (k >= left) {
            return partition(nums, left, end, k);
        }
        return nums[k];
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        KthLargestElementInArray instance = new KthLargestElementInArray();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(instance.findKthLargest(nums, 4));
    }

}
