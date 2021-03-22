import org.junit.Assert;
import org.junit.Test;

public class Q05709STest {

    Q05709s q05709S = new Q05709s();

    @Test
    public void maxAscendingSum() {
        Assert.assertEquals(q05709S.maxAscendingSum(new int[]{10,20,30,5,10,50}), 65);
        Assert.assertEquals(q05709S.maxAscendingSum(new int[]{10,20,30,40,50}), 150);
        Assert.assertEquals(q05709S.maxAscendingSum(new int[]{12,17,15,13,10,11,12}), 33);
        Assert.assertEquals(q05709S.maxAscendingSum(new int[]{100,10,1}), 100);
        Assert.assertEquals(q05709S.maxAscendingSum(new int[]{100}), 100);
    }
}