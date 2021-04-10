/**
 * 给定两个字符串s和t，判断它们是否是同构的。
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "foo", t = "bar"
 * 输出：false
 *
 * 示例 3：
 * 输入：s = "paper", t = "title"
 * 输出：true
 *
 * 提示：
 * 可以假设s和 t 长度相同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00205s {

    /**
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        Character[] sa = new Character[128]; // s与t的映射
        Character[] ta = new Character[128]; // t与s的映射
        char[] sc = s.toCharArray(); // 当需要取字符串的每个字符时，用字符数组是更快的
        char[] tc = t.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if (sa[sc[i]] == null) { // 如果s未映射t的字符
                if (ta[tc[i]] == null) {
                    ta[tc[i]] = sc[i]; // 映射t与s
                    sa[sc[i]] = tc[i]; // 映射s与t
                } else if (ta[tc[i]] != sc[i]) { // 存在多个s映射了t
                    return false;
                }
            } else if (sa[sc[i]] != tc[i]) { // 如果多个s映射了t
                return false;
            }
        }
        return true;
    }
}
