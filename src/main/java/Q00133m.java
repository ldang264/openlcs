import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你无向连通图中一个节点的引用，请你返回该图的深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 * 测试用例格式：
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将给定节点的拷贝作为对克隆图的引用返回。
 *
 * 示例 1：
 * 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
 * 输出：[[2,4],[1,3],[2,4],[1,3]]
 * 解释：
 * 图中有 4 个节点。
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 *
 * 示例 2：
 * 输入：adjList = [[]]
 * 输出：[[]]
 * 解释：输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
 *
 * 示例 3：
 * 输入：adjList = []
 * 输出：[]
 * 解释：这个图是空的，它不含任何节点。
 *
 * 示例 4：
 * 输入：adjList = [[2],[1]]
 * 输出：[[2],[1]]
 *
 * 提示：
 * 节点数不超过 100 。
 * 每个节点值Node.val 都是唯一的，1 <= Node.val <= 100。
 * 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
 * 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p的邻居。
 * 图是连通图，你可以从给定节点访问到所有节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/clone-graph
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00133m {

    private Map<Node, Node> visited = new HashMap<>(); // 原节点与现节点的映射

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node curr = visited.get(node); // 取缓存
        if (curr != null) return curr;
        // 未初始化过，new
        curr = new Node();
        curr.val = node.val;
        visited.put(node, curr);
        curr.neighbors = new ArrayList<>();
        for (Node neighbor : node.neighbors) {
            curr.neighbors.add(cloneGraph(neighbor));
        }
        return curr;
    }

    private Node[] temp = new Node[101];; // 用于存储已经实例化的节点

    public Node cloneGraph1(Node node) {
        if (node == null) return null;
        Node curr = new Node();
        curr.val = node.val;
        temp[node.val] = curr;
        curr.neighbors = new ArrayList<>(); // 邻居
        for (Node neighbor : node.neighbors) {
            if (temp[neighbor.val] == null) { // 邻居还没初始化
                temp[neighbor.val] = cloneGraph1(neighbor); // 则递归
            }
            curr.neighbors.add(temp[neighbor.val]); // 加入邻居到自己的列表
        }
        return curr;
    }

    public static class Node {
        public int val;
        public List<Node> neighbors;
    }
}
