package high_frequency.monotonous_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        for (int i=0; i<=heights.length; i++) {
            int cur = i == heights.length ? -1 : heights[i];
            while (!stack.isEmpty() && cur < heights[stack.peek()]) {
                int pos = stack.pop();
                int height = heights[pos];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }

        return max;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram instance = new LargestRectangleInHistogram();
        int[] heights = {4,2,0,3,2,5};
        instance.largestRectangleArea(heights);
    }



}
