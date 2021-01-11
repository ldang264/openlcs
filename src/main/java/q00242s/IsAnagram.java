package q00242s;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s != null && t != null && s.length() == t.length()) {
            int[] array = new int[26];
            for (int i = 0; i < s.length(); i++) {
                array[s.charAt(i) - 'a']++;
                array[t.charAt(i) - 'a']--;
            }
            for (int i = 0; i < 26; i++) {
                if (array[i] != 0)
                    return false;
            }
            return true;
        }
        return false;
    }
    /*public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s != null && t != null && s.length() == t.length()) {
            int[] as = convert(s);
            int[] at = convert(t);
            for (int i = 0; i < 26; i++) {
                if (as[i] != at[i])
                    return false;
            }
            return true;
        }
        return false;
    }

    private int[] convert(String s) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }
        return array;
    }*/
}
