import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00211mTest {

    Q00211m wordDictionary = new Q00211m();

    @Test
    public void search() {
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        Assert.assertFalse(wordDictionary.search("pad")); // return False
        Assert.assertTrue(wordDictionary.search("bad")); // return True
        Assert.assertTrue(wordDictionary.search(".ad")); // return True
        Assert.assertTrue(wordDictionary.search("b..")); // return True
        Assert.assertTrue(wordDictionary.search("b.d")); // return True
        Assert.assertFalse(wordDictionary.search("b...")); // return True
        Assert.assertFalse(wordDictionary.search("b.")); // return True
    }
}