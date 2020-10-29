package q00050m;

import org.junit.Assert;
import org.junit.Test;

public class MyPow_QuickMulTest {

    private static MyPow_QuickMul qm = new MyPow_QuickMul();

    @Test
    public void myPow1() {
        Assert.assertEquals(1024.00000, qm.myPow(2.00000, 10), 0);
    }
}