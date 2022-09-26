package contest;

import java.util.PriorityQueue;

public class Contest5786 {
    public int sumOfBeauties1(int[] nums) {
        int result = 0;
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> b-a);
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        for (int i=0; i<nums.length; i++) {
            if (i == 0) {
                maxQueue.offer(nums[i]);
            } else if (i > 1) {
                minQueue.offer(nums[i]);
            }
        }

        for (int i=1; i<nums.length-1; i++) {
            int max = maxQueue.peek();
            int min = minQueue.peek();
            if (nums[i] > max && nums[i] < min) {
                result += 2;
            } else if (nums[i-1] < nums[i] && nums[i] < nums[i+1]) {
                result += 1;
            }
            maxQueue.add(nums[i]);
            minQueue.remove(nums[i+1]);
        }

        return result;
    }

    public int sumOfBeauties2(int[] nums) {
        int result = 0;
        for (int i=1; i<nums.length-1; i++) {
            boolean two = true;
            int num = nums[i];
            for (int j=0; j<i; j++) {
                if (nums[j] >= num) {
                    two = false;
                    break;
                }
            }
            if (two) {
                for (int j=i+1; j<nums.length; j++) {
                    if (nums[j] <= num) {
                        two = false;
                        break;
                    }
                }
            }
            if (two) {
                result += 2;
            } else if (nums[i-1] < nums[i] && nums[i] < nums[i+1]) {
                result += 1;
            }
        }
        return result;
    }

    public int sumOfBeauties(int[] nums) {
        int result = 0, n = nums.length;
        int[] leftMax = new int[n];
        leftMax[0] = nums[0];
        for (int i=1; i<n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], nums[i]);
        }
        int[] rightMin = new int[n];
        rightMin[n-1] = nums[n-1];
        for (int i=n-2; i>=0; i--) {
            rightMin[i] = Math.min(rightMin[i+1], nums[i]);
        }
        for (int i=1; i<n-1;i++) {
            if (leftMax[i-1] < nums[i] && nums[i] < rightMin[i+1]) {
                result += 2;
            } else if(nums[i-1] < nums[i] && nums[i] < nums[i+1]) {
                result += 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Contest5786 instance = new Contest5786();
        int[] nums = {1,2,3};
        System.out.println(instance.sumOfBeauties(nums));
    }

}
