import java.util.*;

/**
 * 给一非空的单词列表，返回前k个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *
 * 示例 2：
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *
 * 注意：
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 *
 * 扩展练习：
 * 尝试以O(n log k) 时间复杂度和O(n) 空间复杂度解决。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00692m {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Map.Entry<String, Integer>[] entrys = set.toArray(new Map.Entry[0]);
        sort(entrys, 0, entrys.length - 1);
        List<String> ans = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            ans.add(entrys[i].getKey());
        }
        return ans;
    }

    private void sort(Map.Entry<String, Integer>[] entrys, int left, int right) {
        if (left >= right) return;
        int l = left, r = right;
        Map.Entry<String, Integer> pivot = entrys[left];
        while (left < right) {
            while (left < right && compare(entrys[right], pivot) <= 0) { // 大的往前窜
                right--;
            }
            entrys[left] = entrys[right];
            while (left < right && compare(entrys[left], pivot) >= 0) { // 小的往后窜
                left++;
            }
            entrys[right] = entrys[left];
        }
        entrys[left] = pivot;
        // 因为快排是不稳定的，所以相同个数的字符不能保证字典序，因此要全部排序完成才能取前k个
        sort(entrys, l, left - 1);
        sort(entrys, left + 1, r);
    }

    private int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        int f = e1.getValue() - e2.getValue();
        return f == 0 ? e2.getKey().compareTo(e1.getKey()) : f;
    }
}
