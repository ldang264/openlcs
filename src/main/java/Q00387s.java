import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *  
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00387s {
    public int firstUniqChar(String s) {
        int[] box = new int[s.length()];
        int index = 0;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int buc = s.charAt(i) - 97;
            box[index++] = s.charAt(i);
            arr[buc]++;
        }
        for (int i = 0; i < box.length; i++) {
            if (arr[box[i] - 97] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar1(String s) {
        LinkedHashMap<Character, List<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> list;
            if (map.containsKey(s.charAt(i))) {
                list = map.get(s.charAt(i));
            } else {
                list = new ArrayList<>();
                map.put(s.charAt(i), list);
            }
            list.add(i);
        }
        for (List<Integer> v : map.values()) {
            if (v.size() == 1) {
                return v.get(0);
            }
        }
        return -1;
    }
}
