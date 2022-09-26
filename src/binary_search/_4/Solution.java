package binary_search._4;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length, size2 = nums2.length;
        if ((size1 + size2) % 2 == 0) {
            return (((double)findKthElement(nums1, nums2, 0, 0, (size1 + size2)/2)) + findKthElement(nums1, nums2, 0, 0, (size1+size2)/2+1))/2;
        }
        return findKthElement(nums1, nums2, 0, 0, (size1 + size2)/2 + 1);
    }

    // k is 1 based, start1 start2 are 0 based, therefore any index change involves k, need to - 1
    private int findKthElement(int[] nums1, int[] nums2, int start1, int start2, int k) {
        if (start1 >= nums1.length) {
            return nums2[start2 + k -1];
        }
        if (start2 >= nums2.length) {
            return nums1[start1 + k -1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int halfOfKOfNums1 = start1 + k/2 - 1 < nums1.length ? nums1[start1 + k/2 - 1] : Integer.MAX_VALUE;
        int halfOfKOfNums2 = start2 + k/2 - 1 < nums2.length ? nums2[start2 + k/2 - 1] : Integer.MAX_VALUE;
        if (halfOfKOfNums1 < halfOfKOfNums2) {
            return findKthElement(nums1, nums2, start1 + k/2, start2, k-k/2);
        } else {
            return findKthElement(nums1, nums2, start1, start2 + k/2, k-k/2);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,3,4};
        int[] nums2 = {0,2,5};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }

}
