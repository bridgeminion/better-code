package top_interview_questions;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Use Integer.compare(a, b) to avoid overflow
 */
public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        // to be able to add duplicate number, we need to handle the case in comparator
        Comparator<Integer> comp = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a-b;
        TreeSet<Integer> maxSet = new TreeSet<>(comp.reversed());
        TreeSet<Integer> minSet = new TreeSet<>(comp);
        double[] result = new double[nums.length - k+1];
        for (int i=0; i<k; i++) {
            addNum(minSet, maxSet, i);
        }
        for (int i=k; i<=nums.length; i++) {
            System.out.println("minset first " + nums[minSet.first()] + ", minset last " + nums[minSet.last()]);
            System.out.println("maxset first " + nums[maxSet.first()] + ", maxset last " + nums[maxSet.last()]);
            if (k % 2 == 0) {
                result[i-k] = ((double)nums[minSet.first()] + nums[maxSet.first()])/2.0;
            } else {
                result[i-k] = nums[minSet.first()];
            }
            if (minSet.contains(i-k)) {
                minSet.remove(i-k);
            } else {
                maxSet.remove(i-k);
            }
            if (i < nums.length) {
                addNum(minSet, maxSet, i);
            }
        }

        return result;
    }

    private void addNum(TreeSet<Integer> maxSet, TreeSet<Integer> minSet, int index) {
        maxSet.add(index);
        minSet.add(maxSet.pollFirst());
        if (maxSet.size() < minSet.size()) {
            maxSet.add(minSet.pollFirst());
        }
    }

    public static void main(String[] args) {
        SlidingWindowMedian instance = new SlidingWindowMedian();
        int[] nums = {-2147483648,-2147483648,2147483647,-2147483648,1,3,-2147483648,-100,8,17,22,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
        System.out.println(instance.medianSlidingWindow(nums, 6));
    }

}
