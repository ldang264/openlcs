/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 *
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 *
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 *
 * 示例 3：
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 *
 * 示例 4：
 * 输入：height = [1,2,1]
 * 输出：2
 *
 * 提示：
 * n = height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00011m {

    /**
     * 双指针，官方答案
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int ans = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int area;
            if (height[left] > height[right]) {
                area = height[right] * (right - left);
                right--;
            } else {
                area = height[left] * (right - left);
                left++;
            }
            ans = Math.max(ans, area);
        }
        return ans;
    }

    /**
     * 双循环太垃圾，快超时了
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int ans = 0;
        int i = 1;
        while (i < height.length) {
            if (height[i] != 0) {
                int j = 0;
                while (j < i) {
                    if (height[j] != 0) {
                        int area = Math.min(height[i], height[j]) * (i - j);
                        ans = Math.max(ans, area);
                    }
                    j++;
                }
            }
            i++;
        }
        return ans;
    }
}
