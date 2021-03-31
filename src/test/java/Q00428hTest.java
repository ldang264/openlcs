import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Q00428hTest {

    Q00428h q00428h = new Q00428h();

    @Test
    public void test1() {
        Q00428h.Node root = new Q00428h.Node(1);
        Q00428h.Node c1 = new Q00428h.Node(3);
        root.children = Arrays.asList(c1, new Q00428h.Node(2), new Q00428h.Node(4));
        c1.children = Arrays.asList(new Q00428h.Node(5), new Q00428h.Node(6));
        String data = q00428h.serialize(root);
        Assert.assertEquals(data, "1[3[5 6 ]2 4 ]");
        Q00428h.Node dn = q00428h.deserialize(data);
        Assert.assertEquals(q00428h.serialize(dn),  data);
    }

    @Test
    public void test2() {
        Assert.assertEquals(q00428h.serialize(null), "");
    }
}