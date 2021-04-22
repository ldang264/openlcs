import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00105mTest {

    Q00105m q00105m = new Q00105m();

    @Test
    public void buildTree() {
        Assert.assertEquals(q00105m.buildTree(new int[]{4, 2, 1, 3}, new int[]{1, 2, 3, 4}).toString(), "[4,2,null,1,3,null,null,null,null]");
        Assert.assertEquals(q00105m.buildTree(new int[]{1, 2, 3}, new int[]{2, 3, 1}).toString(), "[1,2,null,null,3,null,null]");
        Assert.assertEquals(q00105m.buildTree(new int[]{1, 2, 4, 3, 5}, new int[]{4, 2, 1, 5, 3}).toString(), "[1,2,3,4,null,5,null,null,null,null,null]");
        Assert.assertEquals(q00105m.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}).toString(), "[3,9,20,null,null,15,7,null,null,null,null]");
    }
}