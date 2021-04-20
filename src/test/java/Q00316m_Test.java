import org.junit.Assert;
import org.junit.Test;

public class Q00316m_Test {

    Q00316m q00316m = new Q00316m();

    @Test
    public void removeDuplicateLetters() {
        Assert.assertEquals(q00316m.removeDuplicateLetters("jhdwakfaehdwn"), "jakfehdwn");
        Assert.assertEquals(q00316m.removeDuplicateLetters("cbacdcbc"), "acdb");
        Assert.assertEquals(q00316m.removeDuplicateLetters("bcabc"), "abc");
    }
}