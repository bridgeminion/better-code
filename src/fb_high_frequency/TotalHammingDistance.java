package fb_high_frequency;

public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                result += nums[i] ^ nums[j];
            }
        }

        return 0;
    }

}
