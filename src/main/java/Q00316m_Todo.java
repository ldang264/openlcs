import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 * <p>
 * 示例 1：
 * 输入：s = "bcabc"
 * 输出："abc"
 * <p>
 * 示例 2：
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00316m_Todo {
    public String removeDuplicateLetters(String s) {
        LinkedList<Integer>[] cs = new LinkedList[128];
        for (int i = 'a'; i <= 'z'; i++) {
            cs[i] = new LinkedList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            cs[s.charAt(i)].addLast(i);
        }
        List<int[]> list = new ArrayList<>(26);
        for (int i = 'a'; i <= 'z'; i++) {
            if (cs[i].size() > 0) {
                while (cs[i].size() > 1) { // 移除靠后的，让较小的更靠前
                    cs[i].removeLast();
                }
                int index = cs[i].getLast(); // 当前最小值的下标
                list.add(new int[]{index, i});
                for (int j = i + 1; j <= 'z'; j++) {
                    if (cs[j].size() > 1) {
                        while (cs[j].getFirst() < index) {
                            cs[j].removeFirst(); // 移除在小字符前面的
                        }
                    }
                }
            }
        }
        list.sort(Comparator.comparingInt(arr -> arr[0]));
        StringBuilder ans = new StringBuilder();
        for (int[] arr : list) {
            ans.append((char) arr[1]);
        }
        return ans.toString();
    }
}
