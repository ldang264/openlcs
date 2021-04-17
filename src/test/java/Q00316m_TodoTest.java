import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00316m_TodoTest {

    Q00316m_Todo q00316m_todo = new Q00316m_Todo();

    @Test
    public void removeDuplicateLetters() {
        Assert.assertEquals(q00316m_todo.removeDuplicateLetters("cbacdcbc"), "acdb");
    }
}