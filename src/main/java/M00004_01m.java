import java.util.HashSet;
import java.util.Set;

/**
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 *
 * 示例1:
 *  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 *  输出：true
 *
 * 示例2:
 *  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 *  输出 true
 *
 * 提示：
 * 节点数量n在[0, 1e5]范围内。
 * 节点编号大于等于 0 小于 n。
 * 图中可能存在自环和平行边。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/route-between-nodes-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00004_01m {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if (n == 0) return false;
        if (n == 1) return true;
        Set<Integer>[] outgoings = new Set[n]; // 下标是起点，Set是目标节点
        for (int i = 0; i < graph.length; i++) {
            if ((start == graph[i][0] && target == graph[i][1])) return true;
            if (outgoings[graph[i][0]] == null) outgoings[graph[i][0]] = new HashSet<>();
            outgoings[graph[i][0]].add(graph[i][1]);
        }
        return dfs(outgoings, start, target, new boolean[n]);
    }

    /**
     *
     * @param outgoings
     * @param start 起点
     * @param target 目标节点
     * @param handle 标记已经遍历过的下标
     * @return
     */
    private boolean dfs(Set<Integer>[] outgoings, int start, int target, boolean[] handle) {
        Set<Integer> outs = outgoings[start];
        handle[start] = true;
        if (outs != null) {
            for (Integer out : outs) {
                // 如果已找到或者子集合里已找到，则返回true
                if (out == target || (!handle[out] && dfs(outgoings, out, target, handle))) return true;
            }
        }
        return false;
    }
}
