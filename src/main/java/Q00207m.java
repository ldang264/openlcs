import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai 则 必须 先学习课程 bi 。
 *
 * 例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 *
 * 示例 2：
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 *
 * 提示：
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00207m {

    /**
     * 有向无环图DAG：Directed Acyclic Graph
     * 入度：指向该顶点的边的个数
     * 出度：该顶点出去的边的个数
     *
     * 首先计算每个顶点的入度
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 因为已知顶点的值为0到numCourses-1，所以可以用数组来表示
        int[] inDegrees = new int[numCourses];
        List<Integer>[] outgoings = new LinkedList[numCourses];
        for (int i = 0; i < outgoings.length; i++) {
            outgoings[i] = new LinkedList<>();
        }
        for (int[] req : prerequisites) {
            inDegrees[req[0]]++; // 计算入度
            outgoings[req[1]].add(req[0]); // 1指向0
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) { // 入度为0的
                queue.offer(i);
            }
        }
        while (queue.size() > 0) {
            int i = queue.poll();
            numCourses--;
            for (Integer out : outgoings[i]) {
                if (--inDegrees[out] == 0) { // 如果指向的元素的度减为0，加入队列
                    queue.offer(out);
                }
            }
        }
        return numCourses == 0;
    }
}
