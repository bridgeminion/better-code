package contest;

public class Contest2209 {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int m = floor.length();
        int[] memo = new int[m];
        helper(floor, 0, memo, numCarpets, carpetLen);

        return memo[0];
    }

    // memo[i]: from position i to end: how many white
    private int helper(String floor, int index, int[] memo, int num, int len) {
        if (index >= floor.length()) {
            return 0;
        }
        if (memo[index] != 0) {
            return memo[index];
        }
        int result = -1;
        if (floor.charAt(index) == '0') {
            result = 1 + helper(floor, index+1, memo, num, len);
            if (num > 0) {
                result = Math.min(result, helper(floor, index+len, memo, num-1, len));
            }
            memo[index] = result;
            return result;
        }
        int temp = index;
        while (temp < floor.length() && floor.charAt(temp) == '1') {
            temp++;
        }
        result = helper(floor, temp, memo, num, len);
        memo[index] = result;

        return result;
    }

    public static void main(String[] args) {
        Contest2209 app = new Contest2209();
        System.out.println(app.minimumWhiteTiles("10110101", 2, 2));
    }

}
