import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class M00008_09mTest {

    M00008_09m m00008_09m = new M00008_09m();

    @Test
    public void generateParenthesis() {
        Assert.assertEquals(m00008_09m.generateParenthesis(3).toString(), "[((())), (()()), (())(), ()(()), ()()()]");
    }
}