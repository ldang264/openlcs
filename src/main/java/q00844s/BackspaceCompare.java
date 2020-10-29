package q00844s;

import java.util.Stack;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *  
 *
 * 提示：
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BackspaceCompare {

    public static void main(String[] args) {
        BackspaceCompare bc = new BackspaceCompare();
        System.out.println(bc.backspaceCompare("ab#c", "ad#c"));
        System.out.println(bc.backspaceCompare("ab##", "c#d#"));
        System.out.println(bc.backspaceCompare("a##c", "#a#c"));
        System.out.println(bc.backspaceCompare("a#c", "b"));
    }

    public boolean backspaceCompare(String S, String T) {
        String rs = reverse(S);
        String ts = reverse(T);
        return rs.equals(ts);
    }

    private String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i=str.length()-1; i>=0; i--){
            if (str.charAt(i) != '#') {
                sb.append(str.charAt(i));
            } else {
                int d = 1; // 有一个#待处理，来自于上面的if
                while (d > 0 && i > 0) {
                    if (str.charAt(i-1) != '#') {
                        d--; // 若不是#，则抵消一个
                    } else {
                        d++; // 若是#，则说明在抵消的途中遇到了新的#，需加1
                    }
                    i--;
                }
            }
        }
        return sb.toString();
    }

    public boolean backspaceCompare1(String S, String T) {
        Stack<Character> s = exec(S);
        Stack<Character> t = exec(T);
        if (s.size() != t.size()) {
            return false;
        }
        while (s.size() > 0) {
            if (s.pop() != t.pop()) {
                return false;
            }
        }
        return true;
    }

    private Stack<Character> exec(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '#') {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else {
                stack.push(str.charAt(i));
            }
        }
        return stack;
    }
}
