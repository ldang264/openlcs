import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Q00078mTest {

    Q00078m q00078m = new Q00078m();

    @Test
    public void subsets() {
        Assert.assertEquals("[[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]", q00078m.subsets(new int[]{4, 3, 2, 1}).toString());
        Assert.assertEquals("[[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]", q00078m.subsets(new int[]{3, 2, 1}).toString());
        List<List<Integer>> lists = q00078m.subsets(new int[]{3, 2, 1, 4, 5, 6, 7, 8, 9, 0});
        System.out.println(lists);
    }
}