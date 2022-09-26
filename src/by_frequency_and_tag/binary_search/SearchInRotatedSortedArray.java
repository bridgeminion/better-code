package by_frequency_and_tag.binary_search;

import java.util.Date;
import java.util.TreeMap;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int peak = findPeak(nums);
        if (nums[0] <= target && target <= nums[peak]) {
            return binarySearch(nums, 0, peak, target);
        } else {
            return binarySearch(nums, peak+1, nums.length - 1, target);
        }
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    private int findPeak(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] < nums[nums.length - 1]) {
            return nums.length - 1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[mid+1]) {
                return mid;
            }
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3};
        SearchInRotatedSortedArray app = new SearchInRotatedSortedArray();
        System.out.println(app.search(nums, 1));
        Date date = new Date();
        System.out.println(date.getMonth() );
        System.out.println(date.getDate() );
        System.out.println(date.getYear());

    }
}
