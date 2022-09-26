package fb_high_frequency;

/**
 * 描述
 * 给定两个字符串 S 和 T, 判断T是否可以通过对S做刚好一次编辑得到。
 * 每次编辑可以选择以下任意一个操作：
 *
 * 在S的任意位置插入一个字符
 * 删除S中的任意一个字符
 * 将S中的任意字符替换成其他字符
 * 样例
 * 例1:
 *
 * 输入: s = "aDb", t = "adb"
 * 输出: true
 * 例2:
 *
 * 输入: s = "ab", t = "ab"
 * 输出: false
 * 解释:
 * s=t ,所以他们不相差一次编辑的距离
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        // write your code here
        int m = s.length(), n = t.length();
        if (Math.abs(m-n) > 1) {
            return false;
        }
        int i=0, j=0, edit = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                if (m > n) {
                    i++;
                } else if (m < n) {
                    j++;
                } else {
                    i++;
                    j++;
                }
                edit++;
                if (edit > 1) {
                    return false;
                }
            }
        }
        if (i != m || j != n ) { // should either one !=
            edit++;
        }

        return edit == 1;
    }

    public static void main(String[] args) {
        OneEditDistance app = new OneEditDistance();
        System.out.println(app.isOneEditDistance("", ""));
    }

}
