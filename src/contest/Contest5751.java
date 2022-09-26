package contest;

public class Contest5751 {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0, j = -1;
        for (int i=nums1.length-1; i>=0; i--) {
            if (j == -1) {
                j = nums2.length - 1;
            }
            while (j >= i && nums1[i] > nums2[j]) {
                j--;
            }
            if (j >= 0 && nums1[i] <= nums2[j]) {
                max = Math.max(max, j - i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Contest5751 instance = new Contest5751();
        int[] nums1 = {30,29,19,5};
        int[] nums2 = {25,25,25,25,25};
        instance.maxDistance(nums1, nums2);
    }

}
