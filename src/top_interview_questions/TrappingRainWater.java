package top_interview_questions;

/**
 * keep trqck of leftHeight, rightHeight, update it if greater than
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, result = 0;
        int leftHeight = height[left], rightHeight = height[right];
        while (left <= right) {
            if (leftHeight < rightHeight) {
                if (height[left] < leftHeight) {
                    result += leftHeight - height[left];
                } else {
                    leftHeight = height[left];
                }
                left++;
            } else {
                if (height[right] < rightHeight) {
                    result += rightHeight - height[right];
                } else {
                    rightHeight = height[right];
                }
                right--;
            }
        }

        return result;
    }
}
