public class Q00208m {

    private TrieNode trie;

    /** Initialize your data structure here. */
    public Q00208m() {
        trie = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode last = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (last.nodes[c - 'a'] == null) {
                last.nodes[c - 'a'] = new TrieNode();
            }
            last = last.nodes[c - 'a'];
        }
        last.match = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = find(word);
        return curr != null && curr.match;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private TrieNode find(String s) {
        TrieNode last = trie;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (last.nodes[c - 'a'] == null) {
                return null;
            }
            last = last.nodes[c - 'a'];
        }
        return last;
    }

    private class TrieNode {
        private TrieNode[] nodes = new TrieNode[26];

        private boolean match; // 表示这个是结束字符节点
    }
}
