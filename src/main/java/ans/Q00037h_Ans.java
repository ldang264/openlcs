package ans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 编写一个程序，通过填充空格来解决数独问题。
 * 一个数独的解法需遵循如下规则：
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
 * 空白格用'.'表示。
 *
 * 一个数独。
 * 答案被标成红色。
 *
 * 提示：
 *
 * 给定的数独序列只包含数字1-9和字符'.'。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是9x9形式的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00037h_Ans {

    private boolean[][] line = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        // 试探每一个点位
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    reset(set);
                    // 判断当前位置有哪些可以填
                    // 行
                    for (int k = 0; k < 9; k++) {
                        set.remove(board[i][k]);
                    }
                    // 列
                    for (int k = 0; k < 9; k++) {
                        set.remove(board[k][j]);
                    }
                    // 当前格子
                    int r = i / 3;
                    int c = j / 3;
                    for (int k = r * 3; k < (r + 1) * 3; k++) {
                        for (int l = c * 3; l < (c + 1) * 3; l++) {
                            set.remove(board[k][l]);
                        }
                    }
                    // 如果是唯一的，就填值，从头开始找
                    if (set.size() == 1) {
                        board[i][j] = set.iterator().next();
                        i = 0;
                        j = -1;
                    }
                }
            }
        }
        // 回溯
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '1';
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }

        dfs(board, 0);
    }
    
    private void reset(Set<Character> set) {
        set.add('1');
        set.add('2');
        set.add('3');
        set.add('4');
        set.add('5');
        set.add('6');
        set.add('7');
        set.add('8');
        set.add('9');
    }

    // 递归
    public void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !valid; ++digit) {
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '1');
                dfs(board, pos + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }

}
