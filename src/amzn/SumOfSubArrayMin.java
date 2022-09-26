package amzn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SumOfSubArrayMin {
    public int sumSubarrayMins(int[] A) {
        int mod = (int) Math.pow(10, 9) + 7;
        int n = A.length, res = 0;
        int[] left = new int[n], right = new int[n];
        // right[i] = j means A[j] is the next less element of A[i].
        Arrays.fill(right, n);
        // left[i] = j means A[j] is the previous less or equal element of A[i].
        Arrays.fill(left, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && A[i] < A[stack.peek()]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++)  {
            System.out.println("i=" + i + ",left[i]=" + left[i] + ",right[i]=" + right[i] + ", result=" + ((i - left[i]) * (right[i] - i)));
            res = (res + A[i] * (i - left[i]) * (right[i] - i) % mod) % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        SumOfSubArrayMin app = new SumOfSubArrayMin();
        int[] A = {5,4,1,3};
        app.sumSubarrayMins(A);
    }
}
