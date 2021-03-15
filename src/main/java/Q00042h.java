/**
 * 给定n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * 提示：
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00042h {
    public int trap(int[] height) {
        if (height.length <= 2) return 0;
        // 左边一直递增的不要
        int left = 0;
        while (left < height.length - 1) {
            if (height[left] > height[left + 1]) break;
            left++;
        }
        // 右边一直递减的不要
        int right = height.length - 1;
        while (right >= 1) {
            if (height[right] > height[right - 1]) break;
            right--;
        }
        if (left >= right) return 0;
        int ans = 0;
        if (height[left] < height[right]) {
            for (int i = left + 1; i < right; i++) {
                if (height[i] >= height[left]) {
                    // 计算一次
                    for (int j = left + 1; j < i; j++) {
                        ans += height[left] - height[j];
                    }
                    left = i;
                }
            }
        } else {
            for (int i = right - 1; i > left; i--) {
                if (height[i] >= height[right]) {
                    // 计算一次
                    for (int j = right - 1; j > i; j--) {
                        ans += height[right] - height[j];
                    }
                    right = i;
                }
            }
        }
        if (left != right - 1) {
            int min = Math.min(height[left], height[right]);
            for (int j = left + 1; j < right; j++) {
                if (height[j] < min) {
                    ans += min - height[j];
                }
            }
        }
        return ans;
    }
}
