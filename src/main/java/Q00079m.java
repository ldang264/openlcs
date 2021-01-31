/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * <p>
 * 提示：
 * <p>
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 参考了答案的visited数组，状态判断用数组更合适
 */
public class Q00079m {

    /**
     * 回溯法
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length]; // 表示是否被访问过的数组
        for (int i = 0; i < board.length; i++) { // 行
            for (int j = 0; j < board[0].length; j++) { // 列
                if (find(board, word, i, j, 0, visited)) return true;
            }
        }
        return false;
    }

    private boolean find(char[][] board, String word, int i, int j, int k, boolean[][] visited) {
        if (board[i][j] != word.charAt(k++)) { // 如果字符不等，则立即返回false
            return false;
        }
        if (k == word.length()) { // 如果已经匹配到字符串结束，则返回true
            return true;
        }
        visited[i][j] = true; // 当前位置匹配上
        // 回溯递归+深度搜索：如果上下左右未被访问过，并且匹配，则返回true
        if ((i > 0 && !visited[i - 1][j] && find(board, word, i - 1, j, k, visited))
                || (i < board.length - 1 && !visited[i + 1][j] && find(board, word, i + 1, j, k, visited))
                || (j > 0 && !visited[i][j - 1] && find(board, word, i, j - 1, k, visited))
                || (j < board[0].length - 1 && !visited[i][j + 1] && find(board, word, i, j + 1, k, visited))) {
            return true;
        }
        return visited[i][j] = false; // 恢复当前位置
    }
}
