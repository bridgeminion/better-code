package contest;

public class Contest5752 {
    long max = 0;
    public int maxSumMinProduct1(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            helper(nums, i, nums[i], nums[i]);
        }
        return (int)(max % ((long)(Math.pow(10, 9) + 7)));
    }

    private void helper(int[] nums, int index, long min, long sum) {
        max = Math.max(max, min*sum);
        if (++index < nums.length) {
            min = Math.min(min, nums[index]);
            sum += nums[index];
            helper(nums, index, min, sum);
        }
    }

    public static void main(String[] args) {
        Contest5752 instance = new Contest5752();
        int[] nums = {3,1,5,6,4,2};
        System.out.println(instance.maxSumMinProduct(nums));
    }

    static class Entry {
        public long sum;
        public long min;

        public Entry(long sum, long min) {
            this.sum = sum;
            this.min = min;
        }
    }
    public int maxSumMinProduct(int[] nums) {
        Entry[] entries = new Entry[nums.length];

        long max = 0;
        long sum = 0, min = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, nums[i]);
            entries[i] = new Entry(sum, min);
            max = Math.max(max, min * sum);
        }
       return (int)(max % ((long)(Math.pow(10, 9) + 7)));
    }

}
