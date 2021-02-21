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
     * 逐行累加比较慢
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        ans = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int min;
                if (j == 0) {
                    min = triangle.get(i - 1).get(0);
                } else if (j == triangle.get(i).size() - 1) {
                    min = triangle.get(i - 1).get(j - 1);
                } else {
                    min = Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1));
                }
                triangle.get(i).set(j, triangle.get(i).get(j) + min);
            }
        }
        for (int j = 0; j < triangle.get(triangle.size() - 1).size(); j++) {
            ans = Math.min(ans, triangle.get(triangle.size() - 1).get(j));
        }
        return ans;
        /**
         ans = Integer.MAX_VALUE;
         find(triangle, 0, 0, 0);
         return ans;
         */
    }

    /**
     * 回溯直接超时
     * @param triangle
     * @param row 当前选取的行
     * @param col 当前选取的列
     */
    private void find(List<List<Integer>> triangle, int row, int col, int current) {
        if (row == triangle.size()) {
            ans = Math.min(ans, current);
            return;
        }
        current += triangle.get(row).get(col);
        find(triangle, row + 1, col, current);
        find(triangle, row + 1, col + 1, current);
    }
}
