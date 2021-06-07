/**
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *
 * 示例：
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 *
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 * 提示：
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 50000 次 addWord 和 search
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-add-and-search-words-data-structure
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00211m {

    private final TrieNode root;

    /** Initialize your data structure here. */
    public Q00211m() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.nodes[c - 'a'] == null) {
                curr.nodes[c - 'a'] = new TrieNode();
            }
            curr = curr.nodes[c - 'a'];
        }
        curr.match = true;
    }

    public boolean search(String word) {
        return backtrace(root, word, 0);
    }

    /**
     * 回溯
     */
    private boolean backtrace(TrieNode curr, String word, int i) {
        if (curr == null) return false;
        if (i == word.length()) return curr.match;
        char c = word.charAt(i);
        if (c == '.') {
            for (TrieNode node : curr.nodes) {
                if (backtrace(node, word, i + 1)) return true;
            }
            return false;
        }
        return backtrace(curr.nodes[c - 'a'], word, i + 1);
    }

    private class TrieNode {
        private TrieNode[] nodes = new TrieNode[26];

        private boolean match;
    }
}
