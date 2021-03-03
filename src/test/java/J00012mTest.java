import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class J00012mTest {

    J00012m j00012m = new J00012m();

    @Test
    public void exist() {
        Assert.assertTrue(j00012m.exist(new char[][]{{'A'}}, "A"));
        Assert.assertFalse(j00012m.exist(new char[][]{{'A'}}, "B"));
        Assert.assertTrue(j00012m.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        Assert.assertTrue(j00012m.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCEE"));
        Assert.assertFalse(j00012m.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
        Assert.assertFalse(j00012m.exist(new char[][]{{'a','b'},{'c','d'}}, "abcd"));
    }
}