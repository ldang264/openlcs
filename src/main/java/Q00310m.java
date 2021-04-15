import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 * 给你一棵包含n个节点的树，标记为0到n - 1 。给定数字n和一个有 n - 1 条无向边的 edges列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
 * 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
 *
 * 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
 *
 * 示例 1：
 * 输入：n = 4, edges = [[1,0],[1,2],[1,3]]
 * 输出：[1]
 * 解释：如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。
 *
 * 示例 2：
 * 输入：n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 * 输出：[3,4]
 *
 * 示例 3：
 * 输入：n = 1, edges = []
 * 输出：[0]
 *
 * 示例 4：
 * 输入：n = 2, edges = [[0,1]]
 * 输出：[0,1]
 *
 * 提示：
 * 1 <= n <= 2 * 104
 * edges.length == n - 1
 * 0 <= ai, bi < n
 * ai != bi
 * 所有 (ai, bi) 互不相同
 * 给定的输入 保证 是一棵树，并且 不会有重复的边
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-height-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00310m {

    /**
     * 参考了答案
     * ----无向无环图A在删除度为1的结点后得到无向无环图B。可以证明，图A所成最小高度树TreeA是由图B所成的最小高度树TreeB接上被删除结点后构成的。
     * 反证法：图B所成的树TreeB如果不是最小高度树，那么存在图B的最小高度树TreeB’，TreeB’的高度比TreeB更小。那么TreeB’接上被删除结点后高度比TreeA更小，这与TreeA是最小高度树矛盾。
     *
     * -----既然图A的最小高度树是由图B的最小高度树接上被删除的结点所成。那么图A的最小高度树的根结点与图B的最小高度树的根结点是相同的，因为，接上被删除的结点不会成为根结点，否则相比不成为根结点的高度还要高1。因此找图A的最小高度树的根结点演变为找图B的最小高度树的根结点。
     *
     * 叶子到根是最短的，一定短于叶子到根到叶子。逐层删除时，根是最后被删除的。
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        int[] degrees = new int[n]; // 存储节点的度
        List<Integer>[] outgoings = new List[n]; // 存储i节点的出线列表
        for (int i = 0; i < edges.length; i++) {
            degrees[edges[i][0]]++;
            degrees[edges[i][1]]++;
            if (outgoings[edges[i][0]] == null) {
                outgoings[edges[i][0]] = new ArrayList<>();
            }
            outgoings[edges[i][0]].add(edges[i][1]);
            if (outgoings[edges[i][1]] == null) {
                outgoings[edges[i][1]] = new ArrayList<>();
            }
            outgoings[edges[i][1]].add(edges[i][0]);
        }
        Queue<Integer> fifo = new LinkedList<>();
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 1) { // 取出度为1的
                fifo.offer(i);
            }
        }
        int size;
        while ((size = fifo.size()) > 0) {
            ans.clear(); // 清空上一层，向根逼近
            while (size-- > 0) {
                int i = fifo.poll();
                ans.add(i);
                for (Integer out : outgoings[i]) {
                    if (--degrees[out] == 1) {
                        fifo.offer(out);
                    }
                }
            }
        }
        return ans;
    }
}
