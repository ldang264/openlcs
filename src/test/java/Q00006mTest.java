import org.junit.Assert;
import org.junit.Test;

public class Q00006mTest {

    Q00006m c = new Q00006m();

    @Test
    public void convert() {
        Assert.assertEquals("LECDIHRNETOESIIG", c.convert("LEETCODEISHIRING", 2));
        Assert.assertEquals("LCIRETOESIIGEDHN", c.convert("LEETCODEISHIRING", 3));
        Assert.assertEquals("LDREOEIIECIHNTSG", c.convert("LEETCODEISHIRING", 4));
    }
}