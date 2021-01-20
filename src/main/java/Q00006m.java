import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING"行数为 3 时，排列如下：
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *
 * 示例1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 *
 * 示例2:
 * 输入: s = "LEETCODEISHIRING", numRows =4
 * 输出:"LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00006m {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) return "";
        if (numRows == 1) return s;
        List<StringBuilder> list = new ArrayList<>(Math.min(s.length(), numRows));
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int pos = 0, neg = numRows - 1;
        boolean inc = true;
        for (int i = 0; i < s.length(); i++) {
            if (inc) {
                list.get(pos++).append(s.charAt(i));
                if (pos == numRows - 1) {
                    pos = 0;
                    inc = false;
                }
            } else {
                list.get(neg--).append(s.charAt(i));
                if (neg == 0) {
                    neg = numRows - 1;
                    inc = true;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            ans.append(list.get(i));
        }
        return ans.toString();
    }
}
