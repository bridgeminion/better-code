package by_frequency_and_tag.dp;

import java.util.HashMap;

public class LongSequence {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int longest = 0;
        for(int i=0; i<arr.length; i++) {
            dp.put(arr[i], dp.getOrDefault(arr[i] - difference, 0) + 1);
            longest = Math.max(longest, dp.get(arr[i]));
        }
        return longest;
    }

    public static void main(String[] args) {
        LongSequence app = new LongSequence();
        int[] arr = {1,5,7,8,5,3,4,2,1};
        System.out.println(app.longestSubsequence(arr, -2));
    }
}
