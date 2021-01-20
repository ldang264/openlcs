import org.junit.Assert;
import org.junit.Test;

public class Q00287mTest {
    Q00287m fd = new Q00287m();

    @Test
    public void findDuplicate() {
        Assert.assertEquals(1, fd.findDuplicate(new int[]{1,3,4,2,1}));
        Assert.assertEquals(2, fd.findDuplicate(new int[]{1,3,4,2,2}));
        Assert.assertEquals(3, fd.findDuplicate(new int[]{3,1,3,4,2}));
        Assert.assertEquals(3, fd.findDuplicate(new int[]{3,1,3,4,3}));
    }
}