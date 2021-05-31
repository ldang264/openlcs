import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q00120mTest {

    Q00120m q00120m = new Q00120m();

    @Test
    public void minimumTotal1() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        Assert.assertEquals(2, q00120m.minimumTotal(list));
    }

    @Test
    public void minimumTotal2() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3, 4));
        Assert.assertEquals(5, q00120m.minimumTotal(list));
    }

    @Test
    public void minimumTotal3() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6, 5, 7));
        Assert.assertEquals(10, q00120m.minimumTotal(list));
    }

    @Test
    public void minimumTotal4() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6, 5, 7));
        list.add(Arrays.asList(4, 1, 8, 3));
        Assert.assertEquals(11, q00120m.minimumTotal(list));
    }
}