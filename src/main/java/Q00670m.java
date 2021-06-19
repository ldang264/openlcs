import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 *
 * 示例 1 :
 *
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 *
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 注意:
 *
 * 给定数字的范围是 [0, 108]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00670m {
    public int maximumSwap(int num) {
        String s = Integer.toString(num);
        int lo = s.length();
        Deque<Integer> stack = new LinkedList<>(); // 单调递减栈
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (stack.size() > 0 && s.charAt(stack.peek()) < c) {
                lo = Math.min(lo, stack.pop()); // 最左边第一个被弹出的下标
            }
            stack.push(i);
        }
        if (lo == s.length()) return num;
        int hi = lo;
        for (int i = lo + 1; i < s.length(); i++) {
            if (s.charAt(i) >= s.charAt(hi)) {
                hi = i; // 找到低位最大的
            }
        }
        return num + (s.charAt(hi) - s.charAt(lo)) * (int) Math.pow(10, s.length() - lo - 1)
            + (s.charAt(lo) - s.charAt(hi)) * (int) Math.pow(10, s.length() - hi - 1);
    }
}
