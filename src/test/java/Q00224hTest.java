import org.junit.Assert;
import org.junit.Test;

public class Q00224hTest {

    Q00224h q00224h = new Q00224h();

    @Test
    public void calculate() {
        Assert.assertEquals(q00224h.calculate("-(3+(4+5))"),-12);
        Assert.assertEquals(q00224h.calculate("-11-(-22-33)-11"), 33);
        Assert.assertEquals(q00224h.calculate("1"), 1);
        Assert.assertEquals(q00224h.calculate("24+36-(54-14)"), 20);
        Assert.assertEquals(q00224h.calculate("1-1"), 0);
        Assert.assertEquals(q00224h.calculate("1+1"), 2);
        Assert.assertEquals(q00224h.calculate(" 2-1+2"), 3);
        Assert.assertEquals(q00224h.calculate("(1+(4+5+2)-3)+(6+8)"), 23);
    }
}