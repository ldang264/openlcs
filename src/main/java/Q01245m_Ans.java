import java.util.ArrayList;
import java.util.List;

/**
 * 给你这棵「无向树」，请你测算并返回它的「直径」：这棵树上最长简单路径的 边数。
 * 我们用一个由所有「边」组成的数组 edges 来表示一棵无向树，其中 edges[i] = [u, v] 表示节点 u 和 v 之间的双向边。
 * 树上的节点都已经用 {0, 1, ..., edges.length} 中的数做了标记，每个节点上的标记都是独一无二的。
 * <p>
 * 示例 1：
 * 输入：edges = [[0,1],[0,2]]
 * 输出：2
 * 解释：
 * 这棵树上最长的路径是 1 - 0 - 2，边数为 2。
 * <p>
 * 示例 2：
 * 输入：edges = [[0,1],[1,2],[2,3],[1,4],[4,5]]
 * 输出：4
 * 解释：
 * 这棵树上最长的路径是 3 - 2 - 1 - 4 - 5，边数为 4。
 * <p>
 * 提示：
 * 0 <= edges.length < 10^4
 * edges[i][0] != edges[i][1]
 * 0 <= edges[i][j] <= edges.length
 * edges 会形成一棵无向树
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/tree-diameter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q01245m_Ans {
    private boolean[] visited;

    private int ans;

    public int treeDiameter(int[][] edges) {
        List<Integer>[] outgoings = new ArrayList[edges.length + 1];
        visited = new boolean[edges.length + 1];
        for (int i = 0; i < outgoings.length; i++) {
            outgoings[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            outgoings[edge[0]].add(edge[1]);
            outgoings[edge[1]].add(edge[0]);
        }
        dfs(outgoings, 0);
        return ans;
    }

    public int dfs(List<Integer>[] map, int index) {
        visited[index] = true;
        List<Integer> list = map[index];
        int max1 = 0;
        int max2 = 0;
        for (int next : list) {
            if (!visited[next]) {
                int num = dfs(map, next);
                if (num > max1) {
                    max1 = num;
                    max2 = max1;
                } else if (num > max2) {
                    max2 = num;
                }
            }
        }
        ans = Math.max(ans, max1 + max2);
        return Math.max(max1, max2) + 1;
    }
}
