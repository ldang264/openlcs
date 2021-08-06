/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字1和0。
 * 
 * 示例1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 
 * 示例2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00067s {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        boolean jw = false;
        char[] acs = a.toCharArray();
        char[] bcs = b.toCharArray();
        int aj = acs.length - 1, bj = bcs.length - 1;
        while (aj >= 0 && bj >= 0) {
            if (acs[aj] == '0' && bcs[bj] == '0') {
                sb.append(jw ? '1' : '0');
                jw = false; // 都是0不会再进位
            } else if (acs[aj] == '1' && bcs[bj] == '1') {
                sb.append(jw ? '1' : '0');
                jw = true; // 都是1一定进位
            } else {
                sb.append(jw ? '0' : '1'); // 否则进位不变
            }
            aj--;
            bj--;
        }
        while (aj >= 0) {
            if (acs[aj] == '0') {
                sb.append(jw ? '1' : '0');
                jw = false;
            } else {
                sb.append(jw ? '0' : '1');
            }
            aj--;
        }
        while (bj >= 0) {
            if (bcs[bj] == '0') {
                sb.append(jw ? '1' : '0');
                jw = false;
            } else {
                sb.append(jw ? '0' : '1');
            }
            bj--;
        }
        if (jw) sb.append('1'); // 如果剩余还有进位
        return sb.reverse().toString();
    }

    /**
     * 评论区比较简洁的答案
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary1(String a, String b) {
        if (a.length() == 0) return b;
        if (b.length() == 0) return a;

        StringBuilder stb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        int c = 0;  // 进位
        while (i >= 0 || j >= 0) {
            if (i >= 0) c += a.charAt(i--) - '0';
            if (j >= 0) c += b.charAt(j--) - '0';
            stb.append(c % 2); // 余数是当前值
            c >>= 1; // 2对应进位1,1不再进位
        }

        if (c > 0) stb.append('1');
        return stb.reverse().toString();
    }
}
