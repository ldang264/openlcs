import tool.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 示例:
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00037h {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder ans = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            root = queue.poll();
            if (root == null) {
                ans.append("null");
            } else {
                ans.append(root.val);
                queue.offer(root.left);
                queue.offer(root.right);
            }
            ans.append(',');
        }
        return ans.deleteCharAt(ans.length() - 1).append(']').toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 2) return null;
        Queue<String> values = new LinkedList<>();
        for (String s : data.substring(1, data.length() - 1).split(",")) {
            values.offer(s);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values.poll()));
        queue.offer(root);
        String child;
        while (values.size() > 0 && queue.size() > 0) {
            TreeNode parent = queue.poll();
            child = values.poll(); // left
            if (!"null".equals(child)) {
                queue.offer(parent.left = new TreeNode(Integer.parseInt(child)));
            }
            child = values.poll(); // right
            if (!"null".equals(child)) {
                queue.offer(parent.right = new TreeNode(Integer.parseInt(child)));
            }
        }
        return root;
    }
}
