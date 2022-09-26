package fb_high_frequency;

/**
 * 给定一个数字，在数字的任意位置插入一个5，使得插入后的这个数字最大。
 *
 * |a| ≤10^6
 *
 *
 * 样例 1:
 *
 * 输入:  a = 234
 * 输出: 5234
 */
public class InsertFive {
    public int InsertFive(int a) {
        String s = String.valueOf(a);
        int i;
        if (a >= 0) {
            i=0;
            while (i < s.length() && s.charAt(i) > '5') {
                i++;
            }
        } else {
            i = 1;
            while (i < s.length() && s.charAt(i) <= '5') {
                i++;
            }
        }
        return Integer.parseInt(s.substring(0, i) + "5" + s.substring(i));
    }

    public static void main(String[] args) {
        InsertFive app = new InsertFive();
        System.out.println(app.InsertFive(548));
    }
}
