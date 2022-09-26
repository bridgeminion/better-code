package binary_search._658;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }
        int left = 0, right = arr.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        int closest = Math.abs(arr[left] - x) <= Math.abs(arr[right] - x) ? left : right;
        int count = 1;
        left = closest - 1;
        right = closest + 1;
        while (count < k) {
            if (left >= 0) {
                if (right < arr.length) {
                    if ((Math.abs(arr[left] - x)) <= Math.abs((arr[right] - x))) {
                        count++;
                        left--;
                    } else {
                        count++;
                        right++;
                    }
                } else {
                    count++;
                    left--;
                }
            } else {
                if (right < arr.length) {
                    count++;
                    right++;
                }
            }
        }

        for (int i=++left; i<=right-1; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,5};
        solution.findClosestElements(nums, 4,3);
    }

}
