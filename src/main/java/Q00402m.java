import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个以字符串表示的非负整数num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 * num 的长度小于 10002 且≥ k。
 * num 不会包含任何前导零。
 *
 * 示例 1 :
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 *
 * 示例 2 :
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 *
 * 示例 3 :
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00402m {

    /**
     * 每次删除第一个最大的，同时删除可能的前导0
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        int index = 0;
        while (sb.length() > 0 && k > 0) {
            boolean del = false;
            while (index < sb.length() - 1) {
                if (sb.charAt(index) > sb.charAt(index + 1)) { // 出现降序
                    sb.deleteCharAt(index); // 删除
                    if (sb.charAt(0) == '0') {
                        int i = 1;
                        while (i < sb.length() && sb.charAt(i) == '0') {
                            i++;
                        }
                        sb.delete(0, i); // 删除前导0
                    }
                    del = true;
                    break;
                }
                index++;
            }
            if (!del) { // 如果一直都递增，则删除最后一个元素，即最大值
                sb.deleteCharAt(index);
            }
            index = Math.max(0, index - 1); // 下一次只需与前一个下标比较大小
            k--;
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    /**
     * 单调栈，将
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits1(String num, int k) {
        if (k == 0) return num;
        Deque<Character> stack = new LinkedList<>(); // 单调递增栈
        int index = 0;
        while (index < num.length()) {
            while (k > 0 && stack.size() > 0 && stack.peek() > num.charAt(index)) { // 如果出现低点，删除
                stack.pop();
                k--;
            }
            stack.push(num.charAt(index++)); // 加入单调栈
        }
        while (stack.size() > 0 && stack.peekLast() == '0') { // 删除前导0
            stack.removeLast();
        }
        if (stack.size() == 0) return "0"; // 直接返回0
        StringBuilder sb = new StringBuilder();
        while (stack.size() > k) {
            sb.append(stack.removeLast()); // 生成返回值
        }
        return sb.toString();
    }

}
