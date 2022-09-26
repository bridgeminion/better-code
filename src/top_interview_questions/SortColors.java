package top_interview_questions;


public class SortColors {
    public void sortColors(int[] nums) {
        int red = 0, blue = nums.length - 1;
        for (int i=0; i<blue; i++) {
            if (nums[i] == 0) {
                swap(nums, i, red);
                red++;
            } else if(nums[i] == 2) {
                swap(nums, i, blue);
                blue--;
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        SortColors instance = new SortColors();
        instance.sortColors(nums);
    }
}
