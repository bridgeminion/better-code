package high_frequency.monotonous_stack;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int leftHeight = height[0], rightHeight = height[right];
        int sum = 0;
        while (left <= right) {
            if (leftHeight < rightHeight) {
                if (height[left] < leftHeight) {
                    sum += leftHeight - height[left];
                } else {
                    leftHeight = height[left];
                }
                left++;
            } else {
                if (height[right] < rightHeight) {
                    sum += rightHeight - height[right];
                } else {
                    rightHeight = height[right];
                }
                right--;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        TrappingRainWater instance = new TrappingRainWater();
        int[] heights = {4,2,0,3,2,5};
        System.out.println(instance.trap(heights));
    }

}
