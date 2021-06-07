import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00212hTest {

    Q00212h q00212h = new Q00212h();

    @Test
    public void findWords() {
        Assert.assertEquals(q00212h.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}},
                new String[]{"oa", "oaa"}).toString(), "[oa, oaa]");
        Assert.assertEquals(q00212h.findWords(new char[][]{{'a'}},
                new String[]{"a"}).toString(), "[a]");
        Assert.assertEquals(q00212h.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}},
                new String[]{"oath", "pea", "eat", "rain"}).toString(), "[oath, eat]");
        Assert.assertEquals(q00212h.findWords(new char[][]{{'a', 'b'}, {'c', 'd'}},
                new String[]{"abcd"}).toString(), "[]");
    }
}