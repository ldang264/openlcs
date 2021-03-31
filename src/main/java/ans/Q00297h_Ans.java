package ans;

import tool.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 * <p>
 * 提示：
 * 树中结点数在范围 [0, 104] 内
 * -1000 <= Node.val <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00297h_Ans {

    /**
     * 广度优先的层序遍历
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // 加入根
        TreeNode curNode;
        while (queue.size() > 0) {
            curNode = queue.poll();
            ans.append(","); // 新节点的分隔符
            if (curNode != null) { // 非空则加入其左右节点
                ans.append(curNode.val);
                queue.add(curNode.left); // 加入左子树
                queue.add(curNode.right); // 加入右子树
            } // 当前节点为空则只有分隔符
        }
        return ans.substring(1);
    }

    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) return null; // null或者空串
        Queue<String> values = new LinkedList<>();
        for (String s : data.split(",", -1)) {
            values.offer(s); // 将整数值和空串放入值的队列
        }
        Queue<TreeNode> queue = new LinkedList<>(); // 节点的队列
        TreeNode root = new TreeNode(Integer.parseInt(values.poll())); // 构造根节点
        queue.add(root); // 根节点入栈
        TreeNode parent;
        String child; // 左右子节点的值
        while (!queue.isEmpty()) {
            parent = queue.poll(); // 弹出父节点
            child = values.poll(); // 弹出左节点
            if (child.length() > 0) {
                parent.left = new TreeNode(Integer.parseInt(child)); // 作为父节点的左节点
                queue.add(parent.left); // 当前左节点入队
            }
            child = values.poll(); // 弹出右节点
            if (child.length() > 0) {
                parent.right = new TreeNode(Integer.parseInt(child)); // 作为父节点的右节点
                queue.add(parent.right); // 当前右节点入队
            }
        }
        return root;
    }

}
