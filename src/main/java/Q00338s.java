/**
 * 给定一个非负整数num。对于0 ≤ i ≤ num 范围中的每个数字i，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 * 输入: 2
 * 输出: [0,1,1]
 *
 * 示例2:
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 * 进阶:
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00338s {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;
        int t = 1;
        int last = 0;
        for (int i = 1; i <= num; i++) {
            if (i == t) { // 2 4 6 8...
                ans[i] = 1;
                last = t; //上一个2的次幂
                t <<= 1;
            } else {
                ans[i] = ans[i - last] + 1; // 15 = 8 + 7
            }
        }
        return ans;
    }
}
