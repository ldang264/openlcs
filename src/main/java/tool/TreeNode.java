package tool;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 广度优先的层序遍历
     * @return
     */
    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this); // 加入根
        TreeNode curNode;
        while (queue.size() > 0) {
            curNode = queue.poll();
            ans.append(","); // 新节点的分隔符
            if (curNode != null) { // 非空则加入其左右节点
                ans.append(curNode.val);
                queue.add(curNode.left); // 加入左子树
                queue.add(curNode.right); // 加入右子树
            } else { // 当前节点为空则加入null
                ans.append("null");
            }
        }
        return "[" + ans.substring(1) + "]";
    }

    public static TreeNode deserialize(String data) {
        if (data == null || data.length() < 3) return null; // null或者空串
        Queue<String> values = new LinkedList<>();
        for (String s : data.substring(1, data.length() - 1).split(",", -1)) {
            values.offer(s); // 将整数值和空串放入值的队列
        }
        Queue<TreeNode> queue = new LinkedList<>(); // 节点的队列
        TreeNode root = new TreeNode(Integer.parseInt(values.poll())); // 构造根节点
        queue.add(root); // 根节点入栈
        TreeNode parent;
        String child; // 左右子节点的值
        while (!queue.isEmpty() && !values.isEmpty()) {
            parent = queue.poll(); // 弹出父节点
            child = values.poll().trim(); // 弹出左节点
            if (!"null".equals(child)) {
                parent.left = new TreeNode(Integer.parseInt(child)); // 作为父节点的左节点
                queue.add(parent.left); // 当前左节点入队
            }
            if (values.size() > 0) {
                child = values.poll().trim(); // 弹出右节点
                if (!"null".equals(child)) {
                    parent.right = new TreeNode(Integer.parseInt(child)); // 作为父节点的右节点
                    queue.add(parent.right); // 当前右节点入队
                }
            }
        }
        return root;
    }

}
