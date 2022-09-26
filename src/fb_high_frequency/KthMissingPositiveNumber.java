package fb_high_frequency;

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int i = 0, start = 1;
        int[] count = new int[k];
        for (int num : arr) {
            while (start < num) {
                count[i++] = start;
                start++;
                if (i == k) {
                    return count[i-1];
                }
            }
            start++;
        }
        if (i < k) {
            return arr[arr.length-1] + (k - i);
        }

        return 0;
    }

    public static void main(String[] args) {
        KthMissingPositiveNumber app = new KthMissingPositiveNumber();
        int[] arr = {1,2,3,4};
        System.out.println(app.findKthPositive(arr, 2));
    }
}
