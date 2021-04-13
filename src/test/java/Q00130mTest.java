import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Q00130mTest {

    Q00130m q00130m = new Q00130m();

    @Test
    public void solve1() {
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        q00130m.solve(board);
        Assert.assertEquals(Arrays.deepToString(board), "[[X, X, X, X], [X, X, X, X], [X, X, X, X], [X, O, X, X]]");
    }

    @Test
    public void solve2() {
        char[][] board = new char[][]{{'X','O','X'},{'X','O','X'},{'X','O','X'}};
        q00130m.solve(board);
        Assert.assertEquals(Arrays.deepToString(board), "[[X, O, X], [X, O, X], [X, O, X]]");
    }

    @Test
    public void solve3() {
        char[][] board = new char[][]{{'X'}};
        q00130m.solve(board);
        Assert.assertEquals(Arrays.deepToString(board), "[[X]]");
    }

    @Test
    public void solve4() {
        char[][] board = new char[][]{{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        q00130m.solve(board);
        Assert.assertEquals(Arrays.deepToString(board), "[[O, O, O], [O, O, O], [O, O, O]]");
    }

}