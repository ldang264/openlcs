/**
 * 给定一个正整数n ，你可以做如下操作：
 *
 * 如果n是偶数，则用n / 2替换n 。
 * 如果n是奇数，则可以用n + 1或n - 1替换n 。
 * n变为 1 所需的最小替换次数是多少？

 * 示例 1：
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 *
 * 示例 2：
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 *
 * 示例 3：
 * 输入：n = 4
 * 输出：2
 *
 * 提示：
 * 1 <= n <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00397m {

    private int ans;

    public int integerReplacement(int n) {
        if (n == 1) return 0;
        ans = 0;
        loop(n);
        return ans;
    }

    private void loop(long n) {
        if (n == 2) {
            ans++;
            return;
        }
        if (n == 3) { // 3需要特殊处理，因为它不是向上转4，而是向下转2最快
            ans += 2;
            return;
        }
        ans++; // 以下情形至少会增加一步处理
        if ((n & (n + 1)) == 0) { // n == 7,15,31,63
            ans++;
            n++; // 转成2的次幂，直接在下一个if处理
        }
        if ((n & (n - 1)) == 0) { // n == 4,8,16,32,64
            while (n > 2) {
                ans++;
                n >>= 1; // 使用右移运算，快速算出幂值
            }
        } else if (n % 2 == 0) {
            loop(n / 2); // 偶数折半
        } else {
            if ((n + 1) % 4 == 0) { // 经过观察，非2次幂的4的倍数一定比2的倍数快一步，比如39应该转40，而不是转38
                loop(n + 1);
            } else {
                loop(n - 1);
            }
        }
    }
}
