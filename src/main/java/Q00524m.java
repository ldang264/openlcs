import java.util.List;
import java.util.PriorityQueue;

/**
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * 示例 1：
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 *
 * 示例 2：
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 *
 * 提示：
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00524m {
    public String findLongestWord(String s, List<String> dictionary) {
        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> { // 大根堆，按照长度优先、字典序优先
           int sub = b.length() - a.length();
           return sub == 0 ? a.compareTo(b) : sub;
        });
        for (String word : dictionary) {
            if (word.length() <= s.length()) { // 排除长度超出的
                queue.offer(word);
            }
        }
        while (queue.size() > 0) {
            String word = queue.poll();
            int i = s.length() - 1, j = word.length() - 1;
            while (j >= 0 && i >= j) {
                if (s.charAt(i) == word.charAt(j)) {
                    j--;
                }
                i--;
            }
            if (j == -1) { // 全部匹配
                return word;
            }
        }
        return "";
    }
}
