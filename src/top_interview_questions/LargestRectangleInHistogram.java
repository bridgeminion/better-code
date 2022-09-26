package top_interview_questions;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i=0; i<=heights.length; i++) {
            int curr = i == heights.length ? -1 : heights[i]; // push -1 at the end make sure all elements will pop out
            while (!stack.isEmpty() && heights[stack.peek()] > curr) {
                int height = heights[stack.pop()]; // pop first, width is decided by previous element
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram instance = new LargestRectangleInHistogram();
        int[] heights = {2,1,5,6,2,3};
        System.out.println(instance.largestRectangleArea(heights));
    }
}
