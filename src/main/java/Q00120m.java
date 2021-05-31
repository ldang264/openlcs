import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
 *
 * 示例 2：
 * 输入：triangle = [[-10]]
 * 输出：-10
 *
 * 提示：
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 *
 * 进阶：
 *
 * 你可以只使用 O(n)的额外空间（n 为三角形的总行数）来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00120m {

    /**
     * 自顶向下
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int ans = Integer.MAX_VALUE;
        int[] nums = new int[triangle.size()];
        nums[0] = triangle.get(0).get(0); // 第一行直接赋值
        for (int i = 1; i < triangle.size(); i++) {
            nums[i] = nums[i - 1] + triangle.get(i).get(i); // 处理当前行最后一个位置
            for (int j = i - 1; j > 0; j--) { // 处理非首位位置
                nums[j] = triangle.get(i).get(j) + Math.min(nums[j - 1], nums[j]);
            }
            nums[0] += triangle.get(i).get(0); // 处理当前行第一个位置
        }
        for (int j = 0; j < nums.length; j++) {
            ans = Math.min(ans, nums[j]);
        }
        return ans;
    }

    private int ans;

    /**
     * 自底向上
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        List<Integer> next = triangle.get(triangle.size() - 1);
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> curr = triangle.get(i);
            for (int j = 0; j < curr.size(); j++) {
                curr.set(j, curr.get(j) + Math.min(next.get(j), next.get(j + 1)));
            }
            next = curr;
        }
        return triangle.get(0).get(0);
    }
}
