import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。（这里，平面上两点之间的距离是欧几里德距离。）
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 * 示例 1：
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 *
 * 示例 2：
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *
 * 提示：
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00973m {

    /**
     * Top K问题，采用快速排序+中间判断的方式
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        sort(points, K, 0, points.length - 1);
        return Arrays.copyOf(points, K);
    }

    /**
     * 快速排序
     * @param points
     * @param K
     * @param left
     * @param right
     */
    private void sort(int[][] points, int K, int left, int right) {
        if (left >= right) return; // 超出则退出
        int l = left; // 备份左界
        int r = right; // 备份右界
        int[] pivot = points[left]; // 保存基准值
        while (left < right) {
            while (left < right && compare(points[right], pivot) >= 0) { // 从右向左，找到比基准值小的就停
                right--;
            }
            points[left] = points[right]; // 把小的数字换到前面来
            while (left < right && compare(points[left], pivot) <= 0) { // 从左向右，找到比基准值大的就停
                left++;
            }
            points[right] = points[left]; // 把大值换到后面去
        }
        points[left] = pivot; // 将基准值放到正确的位置,左边比它小，右边比它大
        // l到left总共是left - l + 1个数
        int dist = K - (left - l + 1);
        if (dist < 0) { // K比这个个数小，还要在左边找
            sort(points, K, l, left - 1);
        } else if (dist > 0) { // K比这个数大，还要在右边找，但是只需要找剩下的数了
            sort(points, dist, left + 1, r);
        }
    }

    private int compare(int[] a, int[] b) {
        return dist(a) - dist(b);
    }

    private int dist(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }

    /**
     * 优先级队列，小根堆
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest1(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0] * o[0] + o[1] * o[1]));
        queue.addAll(Arrays.asList(points));
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }

    /**
     * 直接排序，比较low
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest2(int[][] points, int K) {
        Arrays.sort(points, (o1, o2) -> o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] - o2[1] * o2[1]); // 排序
        return Arrays.copyOf(points, K); // 取前K个元素
    }
}
