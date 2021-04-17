import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class J00037hTest {

    J00037h j00037h = new J00037h();

    @Test
    public void serialize() {
        TreeNode root = TreeNode.deserialize("[1,2,3,null,null,4,5]");
        String data = j00037h.serialize(root);
        TreeNode root0 = j00037h.deserialize(data);
        Assert.assertEquals(root.toString(), root0.toString());
    }
}