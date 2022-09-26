package by_frequency_and_tag.dp;

public class JumpGameTwo {
    public int jump(int[] nums) {
        int steps = 0, curLevelEnd = 0, nxtLevelEnd = 0;
        for(int i=0;i<nums.length;i++) {
            if(i>curLevelEnd) {
                steps++;
                curLevelEnd = nxtLevelEnd;
            }
            nxtLevelEnd = Math.max(nxtLevelEnd, i+nums[i]);
        }
        return steps;
    }
    public static void main(String[] args) {
        JumpGameTwo app = new JumpGameTwo();
        int[] A = {2,3,1,1,4};
        app.jump(A);
    }
}
