package contest;

public class Contest2164 {
    public int[] sortEvenOdd(int[] nums) {
        int[] bucket1 = new int[101];
        int[] bucket2 = new int[101];
        for (int i=0; i<nums.length; i+=2) {
            bucket1[nums[i]]++;
        }
        for (int i=1; i<nums.length; i+=2) {
            bucket2[nums[i]]++;
        }
        int i = 0, j = 0;
        while (i<nums.length && j<bucket1.length) {
            while (bucket1[j] == 0) {
                j++;
            }
            int times = bucket1[j];
            for (int k=0; k<times; k++) {
                nums[i] = j;
                i+=2;
            }
            j++;
        }
        i = 1;
        j = bucket2.length-1;
        while (i<nums.length && j>=0) {
            while (bucket2[j] == 0) {
                j--;
            }
            int times = bucket2[j];
            for (int k=0; k<times; k++) {
                nums[i] = j;
                i+=2;
            }
            j--;
        }

        return nums;
    }

    public static void main(String[] args) {
        Contest2164 app = new Contest2164();
        int[] nums = {4,1,2,3};
        System.out.println(app.sortEvenOdd(nums));
    }
}
