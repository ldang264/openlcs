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
        if (height.length <= 2) return 0; // 不构成水坑
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
        int ans = 0, pos = left, i = left, temp = 0; // 双指针
        while (i <= right) {
            int val = height[pos] - height[i];
            if (val > 0) { // 出现水坑
                temp += val;
            } else {
                pos = i; // 出现左低右高或者左右等高
                ans += temp;
                temp = 0;
            }
            i++;
        }
        pos = i = right; // 还原指针
        temp = 0;
        while (i >= left) {
            int val = height[pos] - height[i];
            if (val >= 0) { // 出现水坑
                temp += val;
            } else {
                pos = i; // 左右等高已经处理过，找左高右低的
                ans += temp;
                temp = 0;
            }
            i--;
        }
        return ans;
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        if (height.length <= 2) return 0; // 不构成水坑
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
        int ans = 0, pos = left, i = left; // 双指针
        while (i <= right) {
            if (height[i] >= height[pos]) { // 出现左低右高或者左右等高
                for (int j = pos + 1; j < i; j++) {
                    ans += height[pos] - height[j];
                }
                pos = i;
            }
            i++;
        }
        pos = i = right; // 还原指针
        while (i >= left) {
            if (height[i] > height[pos]) { // 左右等高已经处理过，找左高右低的
                for (int j = pos - 1; j > i; j--) {
                    ans += height[pos] - height[j];
                }
                pos = i;
            }
            i--;
        }
        return ans;
    }
}
