/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 提示：
 * 0 <= num < 231
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00046m {

    private int ans;

    /**
     * 回溯
     * @param num
     * @return
     */
    public int translateNum(int num) {
        ans = 0;
        char[] cs = Integer.toString(num).toCharArray();
        backtrace(cs, 0);
        return ans;
    }

    private void backtrace(char[] cs, int i) {
        if (i >= cs.length) ans++;
        else {
            backtrace(cs, i + 1); // 一个字符是肯定可以选的
            if (i < cs.length - 1 && (cs[i] == '1' || (cs[i] == '2' && cs[i + 1] <= '5'))) { // 两个字符可选的条件
                backtrace(cs, i + 2);
            }
        }
    }

    /**
     * 动态规划 双一百
     * @param num
     * @return
     */
    public int translateNumDp(int num) {
        String s = Integer.toString(num);
        int d0 = 1, d1 = 1, d2; // dp[i]表示取到第i个数时的翻译的格式，i从0开始
        char prev = s.charAt(0), next;
        for (int i = 1; i < s.length(); i++) {
            d2 = d1;
            next = s.charAt(i);
            if (prev == '1' || (prev == '2' && next <= '5')) { // 可以选两个字符的情形
                d2 += d0;
            }
            prev = next;
            d0 = d1;
            d1 = d2;
        }
        return d1;
    }
}
