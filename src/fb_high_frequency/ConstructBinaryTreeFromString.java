package fb_high_frequency;

import common.TreeNode;

public class ConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int m = s.length();
        TreeNode root;
        int i = 0, j = 0;
        while (j<m && s.charAt(j) != '(') {
            j++;
        }
        root = new TreeNode(Integer.valueOf(s.substring(i, j)));
        j++;
        int leftStart = j, count = 1;
        while (j < m && count != 0) {
            if (s.charAt(j) == '(') {
                count++;
            } else if (s.charAt(j) == ')') {
                count--;
            }
            j++;
        }
        if (j <= m) {
            root.left = str2tree(s.substring(leftStart, j - 1));
        }
        if (j+1 < m) {
            root.right = str2tree(s.substring(j+1, s.length()-1));
        }

        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromString app = new ConstructBinaryTreeFromString();
        System.out.println(app.str2tree("4(2(3)(1))(6(5))"));
//        System.out.println(app.str2tree("6(5)"));
    }
}
