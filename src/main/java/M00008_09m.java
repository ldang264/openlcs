import java.util.ArrayList;
import java.util.List;

/**
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bracket-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00008_09m {

    private List<String> ans;

    private char[] temp;

    private int l, r, idx;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        temp = new char[n << 1];
        idx = 0; // 当前摆放的位置
        l = r = n; // 左右括号的个数
        backtrace();
        return ans;
    }

    private void backtrace() {
        if (idx == temp.length) { // 摆满
            ans.add(new String(temp));
        } else {
            if (l > 0){ // 左括号可摆
                temp[idx++] = '(';
                l--;
                backtrace();
                l++;
                idx--;
            }
            if (l < r) { // 右括号可摆
                temp[idx++] = ')';
                r--;
                backtrace();
                r++;
                idx--;
            }
        }
    }
}
