package top_interview_questions;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int xor = 0;
        for (int i=0; i<nums.length; i++) {
            xor ^= i;
            xor ^= nums[i];
        }

        return xor;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber instance = new FindTheDuplicateNumber();
        int[] nums = {1,3,4,2,2};
        System.out.println(instance.findDuplicate(nums));
    }

}
