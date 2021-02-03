import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
 *
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 *
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 *
 * 示例 3：
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 *
 * 示例 4：
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00394m {
    public String decodeString(String s) {
        Stack<String> numStack = new Stack<>();
        Stack<String> charStack = new Stack<>();
        int status = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') { // 数字
                if (status == 0) {
                    numStack.push(numStack.pop() + c);
                } else {
                    numStack.push(c + "");
                }
                status = 0;
            } else if (c == '[') { // 左中括号
                charStack.push("[");
                status = 1;
            } else if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') { // 字母
                if (status == 2) {
                    charStack.push(charStack.pop() + c);
                } else {
                    charStack.push(c + "");
                }
                status = 2;
            } else { // 右中括号
                status = 3;
                StringBuilder cs = new StringBuilder();
                String p;
                while (charStack.size() > 0 && !"[".equals(p = charStack.pop())) {
                    cs.insert(0, p);
                }
                String ns = numStack.pop();
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < Integer.parseInt(ns); j++) {
                    sb.append(cs);
                }
                charStack.push(sb.toString());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String c : charStack) {
            sb.append(c);
        }
        return sb.toString();
    }

    /*public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']') { // 弹出字符串、第一个[和它前面的数字
                int size = stack.size();
                boolean findChar = false, findLeft = false;
                List<Character> cl = new ArrayList<>();
                StringBuilder nsb = new StringBuilder();
                while (size-- > 0) {
                    char p = stack.pop();
                    if (p == '[') {
                        if (findLeft) {
                            stack.push(p);
                            break;
                        }
                        findLeft = true;
                    } else if (('a' <= p && p <= 'z') || ('A' <= p && p <= 'Z')) {
                        if (findChar) {
                            stack.push(p);
                            break;
                        }
                        cl.add(p);
                    } else {
                        findChar = true;
                        nsb.append(p);
                    }
                }
                int num = Integer.parseInt(nsb.reverse().toString());
                for (int j = 0; j < num; j++) {
                    for (int k = cl.size() - 1; k >= 0; k--) {
                        stack.push(cl.get(k));
                    }
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }*/
}
