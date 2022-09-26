package high_frequency.monotonous_stack;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        Deque<int[]> stack = new LinkedList<>();
        int[] result = new int[T.length];
        for (int i=0; i<T.length; i++) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek()[0] < T[i]) {
                    int[] popped = stack.pop();
                    result[popped[1]] = i - popped[1];
                }
            }
            stack.push(new int[]{T[i], i});
        }

        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures instance = new DailyTemperatures();
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(instance.dailyTemperatures(temps));
    }

}
