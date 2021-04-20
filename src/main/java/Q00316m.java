import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 * 
 * 示例 1：
 * 输入：s = "bcabc"
 * 输出："abc"
 * 
 * 示例 2：
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * 
 * 提示：
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00316m {
    public String removeDuplicateLetters(String s) {
        int[] cs = new int[128];
        for (int i = 0; i < s.length(); i++) {
            cs[s.charAt(i)]++;
        }
        Deque<Character> stack = new LinkedList<>();
        boolean[] exists = new boolean[128];
        char top;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cs[c]--; // 遍历一个，计数就减一
            if (!exists[c]) { // 栈中没有c
                while (stack.size() > 0 && (top = stack.peek()) > c) {
                    if (cs[top] == 0) break; // 唯一的一个已经在栈中，不能再弹出了
                    exists[top] = false;
                    stack.pop(); // 剩余的还有，则弹出
                }
                stack.push(c);
                exists[c] = true;
            }
        }
        StringBuilder ans = new StringBuilder();
        while (stack.size() > 0) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}
