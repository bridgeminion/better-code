package amzn;

/**
 * Assume you have an array of length n initialized with all 0’s and are given k update operations.
 *
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex … endIndex] (startIndex and endIndex inclusive) with inc.
 *
 * Return the modified array after all k operations were executed.
 *
 * Example:
 *
 * Given:
 *
 *     length = 5,
 *     updates = [
 *         [1,  3,  2],
 *         [2,  4,  3],
 *         [0,  2, -2]
 *     ]
 *
 * Output:
 *
 *     [-2, 0, 3, 5, 3]
 */
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for (int[] update : updates) {
            result[update[0]] += update[2];
            if (update[1] < length-1) {
                result[update[1]+1] -= update[2];
            }
        }
        int sum = 0;
        for (int i=0; i<length; i++) {
            sum += result[i];
            result[i] = sum;
        }

        return result;
    }

    public static void main(String[] args) {
        RangeAddition app = new RangeAddition();
        int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
        System.out.println(app.getModifiedArray(5, updates));
    }
}
