/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * <p>
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00012m {

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (find(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, int i, int j, String word, int index) {
        char c;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || (c = word.charAt(index)) != board[i][j]) return false; // 超出或者不相等，返回false
        if (++index == word.length()) return true; // 全部匹配，返回true
        board[i][j] = '*'; // 设置为一个不相干的字符，省去visited
        if (find(board, i + 1, j, word, index) // 检查下一行
                || find(board, i - 1, j, word, index) // 检查上一行
                || find(board, i, j + 1, word, index) // 检查右一列
                || find(board, i, j - 1, word, index)) // 检查左一列
            return true;
        board[i][j] = c; // 恢复字符
        return false;
    }

    // 深度优先
    private boolean[][] visited;

    public boolean exist1(char[][] board, String word) {
        if (word == null || word.length() == 0) return false;
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (find1(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find1(char[][] board, int i, int j, String word, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || visited[i][j] || word.charAt(index) != board[i][j]) return false;
        if (index++ == word.length() - 1) return true;
        visited[i][j] = true;
        if (find(board, i + 1, j, word, index)
                || find(board, i - 1, j, word, index)
                || find(board, i, j + 1, word, index)
                || find(board, i, j - 1, word, index))
            return true;
        return visited[i][j] = false;
    }
}
