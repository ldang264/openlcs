import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Q00046mTest {

    Q00046m q00046m = new Q00046m();

    @Test
    public void permute() {
        List<List<Integer>> ans1 = q00046m.permute(new int[]{1});
        Assert.assertEquals("[[1]]", ans1.toString());
        List<List<Integer>> ans2 = q00046m.permute(new int[]{1, 2});
        Assert.assertEquals("[[1, 2], [2, 1]]", ans2.toString());
        List<List<Integer>> ans3 = q00046m.permute(new int[]{1, 2, 3});
        Assert.assertEquals("[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]", ans3.toString());
    }
}