import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
 *
 * 示例：
 * 输入：
 * big = "mississippi"
 * smalls = ["is","ppi","hi","sis","i","ssippi"]
 * 输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
 * 提示：
 *
 * 0 <= len(big) <= 1000
 * 0 <= len(smalls[i]) <= 1000
 * smalls的总字符数不会超过 100000。
 * 你可以认为smalls中没有重复字符串。
 * 所有出现的字符均为英文小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multi-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00017_17m {
    public int[][] multiSearch(String big, String[] smalls) {
        TrieNode root = new TrieNode(), curr;
        for (int i = 0; i < big.length(); i++) {
            curr = root;
            for (int j = i; j < big.length(); j++) {
                int idx = big.charAt(j) - 'a';
                if (curr.nodes[idx] == null) {
                    curr.nodes[idx] = new TrieNode();
                }
                curr.nodes[idx].indexes.add(j);
                curr = curr.nodes[idx];
            }
        }
        List[] temp = new List[smalls.length];
        for (int i = 0; i < smalls.length; i++) {
            curr = root;
            for (int j = 0; j < smalls[i].length(); j++) {
                int idx = smalls[i].charAt(j) - 'a';
                if (curr.nodes[idx] == null) {
                    curr = null;
                    break;
                }
                curr = curr.nodes[idx];
            }
            if (curr != null) {
                temp[i] = curr.indexes;
            }
        }
        int[][] ans = new int[smalls.length][];
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == null) {
                ans[i] = new int[0];
            } else {
                ans[i] = new int[temp[i].size()];
                for (int j = 0; j < temp[i].size(); j++) {
                    ans[i][j] = ((int) temp[i].get(j)) - smalls[i].length() + 1;
                }
            }
        }
        return ans;
    }

    private static class TrieNode {
        private TrieNode[] nodes = new TrieNode[26];

        private List<Integer> indexes = new ArrayList<>();
    }
}
