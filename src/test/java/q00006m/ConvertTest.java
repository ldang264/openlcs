package q00006m;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertTest {

    Convert c = new Convert();

    @Test
    public void convert() {
        Assert.assertEquals("LECDIHRNETOESIIG", c.convert("LEETCODEISHIRING", 2));
        Assert.assertEquals("LCIRETOESIIGEDHN", c.convert("LEETCODEISHIRING", 3));
        Assert.assertEquals("LDREOEIIECIHNTSG", c.convert("LEETCODEISHIRING", 4));
    }
}