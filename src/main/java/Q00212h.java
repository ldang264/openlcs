import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 示例 1：
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 *
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 *
 * 提示：
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00212h {

    private List<String> ans;

    private boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        visited = new boolean[board.length][board[0].length];
        TrieNode root = new TrieNode(), curr;
        // 1.将words构建为前缀树
        for (String word : words) {
            curr = root;
            for (int j = 0; j < word.length(); j++) {
                int idx = word.charAt(j) - 'a';
                if (curr.nodes[idx] == null) {
                    curr.nodes[idx] = new TrieNode();
                }
                curr = curr.nodes[idx];
            }
            curr.word = word;
        }
        ans = new ArrayList<>();
        // 2.回溯
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrace(root, board, i, j);
            }
        }
        return ans;
    }

    private void backtrace(TrieNode curr, char[][] board, int i, int j) {
        if (i == -1 || i == board.length || j == -1 || j == board[0].length || visited[i][j]) return;
        int idx = board[i][j] - 'a';
        curr = curr.nodes[idx];
        if (curr == null) return;
        if (curr.word != null) {
            ans.add(curr.word);
            curr.word = null; // 剪枝
        }
        visited[i][j] = true;
        backtrace(curr, board, i + 1, j);
        backtrace(curr, board, i - 1, j);
        backtrace(curr, board, i, j + 1);
        backtrace(curr, board, i, j - 1);
        visited[i][j] = false;
    }

    private class TrieNode {
        private TrieNode[] nodes = new TrieNode[26];

        private String word;
    }
}
