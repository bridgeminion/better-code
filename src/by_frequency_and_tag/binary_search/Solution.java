package by_frequency_and_tag.binary_search;

import java.util.Random;

public class Solution {

    private int[] prefixSum;
    private int sum = 0;
    private Random random;
    public Solution(int[] w) {
        this.random = new Random();
        prefixSum = new int[w.length];
        for (int i=0; i<w.length; i++) {
            sum += w[i];
            prefixSum[i] = sum;
        }
    }

    public int pickIndex() {
        int target = random.nextInt(sum+1);
        System.out.println(target);
        return binarySearch(prefixSum, target);
    }

    private int binarySearch1(int[] list, int target) {
        int left = 0, right = list.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (list[mid] == target) {
                return mid;
            } else if(list[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int binarySearch(int[] list, int target) {
        int left = 0, right = list.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (list[mid] == target) {
                return mid;
            } else if(list[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list[left] < target ? right : left;
    }

    public static void main(String[] args) {
        int[] list = {3,14,1,7};
        Solution app = new Solution(list);
        System.out.println(app.pickIndex());
        System.out.println(app.pickIndex());
        System.out.println(app.pickIndex());
        System.out.println(app.pickIndex());
        System.out.println(app.pickIndex());
        System.out.println(app.pickIndex());
        System.out.println(app.pickIndex());
        System.out.println(app.pickIndex());
        System.out.println(app.pickIndex());
        System.out.println(app.pickIndex());
        System.out.println(app.pickIndex());
        System.out.println(app.pickIndex());
        System.out.println(app.pickIndex());
        System.out.println(app.pickIndex());
        System.out.println(app.pickIndex());
        System.out.println(app.pickIndex());
        System.out.println(app.pickIndex());
        System.out.println(app.pickIndex());
        System.out.println(app.pickIndex());
    }

}
