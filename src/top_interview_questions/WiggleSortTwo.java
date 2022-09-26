package top_interview_questions;

public class WiggleSortTwo {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return;
        }
        int k = n % 2 == 0 ? n/2 : (n+1)/2;
        int mid = kthLargestElement(nums, k);
        int[] wiggle = new int[n];
        int left = 0, right = mid, index = 0;
        while (index < n) {
            wiggle[index++] = nums[left++];
            if (right < n) {
                wiggle[index++] = nums[right++];
            }
        }
        for (int i=0; i<n; i++) {
            nums[i] = wiggle[i];
        }
    }

    private int kthLargestElement(int[] nums, int k) {
        int left = 0, right = nums.length-1;
        while (true) {
            int i = partition(nums, left, right);
            if (i == k) {
                return k;
            } else if (i < k) {
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i=j+1; i<=right; i++) {
            if(nums[i] < pivot) {
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);

        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        WiggleSortTwo instance = new WiggleSortTwo();
        int[] nums = {1,1,2,1,2,2,1};
        instance.wiggleSort(nums);
    }

}
