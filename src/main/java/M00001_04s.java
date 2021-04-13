import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * 回文串不一定是字典当中的单词。
 *
 * 示例1：
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00001_04s {

    /**
     * 用set,俩俩相消，最后剩余的奇数个数的字符不能超过1个
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.remove(c)) { // c不存在时返回false，则将c加入到集合
                set.add(c);
            }
        }
        return set.size() <= 1;
    }

    /**
     * 考察出现奇数次的字符，最多不超过一个字符可以出现奇数次
     * 效率太低
     * @param s
     * @return
     */
    public boolean canPermutePalindrome1(String s) {
        Map<Character, Integer> map = new HashMap<>(); // 键是字符，值是其计数
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        boolean hasOdd = false; // 是否有奇数
        for (Integer count : map.values()) {
            if ((count & 1) == 1) { // 是奇数
                if (hasOdd) return false;
                hasOdd = true;
            }
        }
        return true;
    }
}
