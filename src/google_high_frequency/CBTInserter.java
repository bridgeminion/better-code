package google_high_frequency;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CBTInserter {
    List<TreeNode> list = new ArrayList<>();
    public CBTInserter(TreeNode root) {
        list.add(root);
        for (int i=0; i<list.size(); i++) {
            TreeNode node = list.get(i);
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
        }
    }

    public int insert(int val) {
        TreeNode newNode = new TreeNode(val);
        TreeNode parent = list.get((list.size() - 1) / 2);
        if (parent.left == null) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        list.add(newNode);
        return parent.val;
    }

    public TreeNode get_root() {
        return list.get(0);
    }

}
