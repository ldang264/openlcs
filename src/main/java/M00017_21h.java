/**
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。感谢 Marcos 贡献此图。
 *
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/volume-of-histogram-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00017_21h {
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int ans = 0, base = 0, temp = 0, sub;
        for (int i = 1; i < height.length; i++) {
            sub = height[base] - height[i];
            if (sub <= 0) { // 处理左低右高或左右齐平
                base = i;
                ans += temp;
                temp = 0;
            } else {
                temp += sub; // 加入候选结果
            }
        }
        base = height.length - 1;
        temp = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            sub = height[base] - height[i];
            if (sub < 0) { // 处理左高右低
                base = i;
                ans += temp;
                temp = 0;
            } else {
                temp += sub;
            }
        }
        return ans;
    }
}
