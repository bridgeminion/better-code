package top_interview_questions;

import java.util.Random;

public class Solution {
    int[] nums;
    Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffle = nums.clone();
        for (int i=shuffle.length-1; i>0; i--) {
            int randomIndex = random.nextInt(i+1); // random index should include n-1
            int tmp = shuffle[i];
            shuffle[i] = shuffle[randomIndex];
            shuffle[randomIndex] = tmp;
        }
        return shuffle;
    }

}
