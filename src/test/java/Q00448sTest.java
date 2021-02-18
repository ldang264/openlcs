import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Q00448sTest {

    Q00448s q00448s = new Q00448s();

    @Test
    public void findDisappearedNumbers() {
        List<Integer> ans1 = q00448s.findDisappearedNumbers(new int[]{4, 3, 2, 7, 7, 2, 3, 1});
        Assert.assertEquals("[5, 6, 8]", ans1.toString());
        List<Integer> ans2 = q00448s.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        Assert.assertEquals("[5, 6]", ans2.toString());
    }
}