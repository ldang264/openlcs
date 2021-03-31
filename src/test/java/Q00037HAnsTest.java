import ans.Q00037h_Ans;
import org.junit.Test;

import java.util.Arrays;

public class Q00037HAnsTest {

    Q00037h_Ans q00037HAns = new Q00037h_Ans();

    @Test
    public void solveSudoku() {
        char[][] board = new char[][]{
            {'.', '.', '2', '.', '9', '.', '7', '.', '.'},
            {'7', '8', '.', '.', '.', '.', '.', '6', '.'},
            {'.', '1', '.', '.', '.', '5', '.', '8', '.'},
            {'.', '5', '.', '.', '1', '.', '.', '.', '3'},
            {'.', '7', '.', '.', '.', '9', '.', '1', '.'},
            {'6', '.', '.', '.', '.', '.', '.', '9', '.'},
            {'.', '4', '.', '2', '.', '.', '.', '7', '.'},
            {'.', '6', '.', '.', '.', '.', '.', '4', '2'},
            {'.', '.', '8', '.', '7', '.', '1', '.', '.'}
        };
        System.out.println(Arrays.deepToString(board));
        System.out.println();
        System.out.println();
        System.out.println();
        q00037HAns.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }
}