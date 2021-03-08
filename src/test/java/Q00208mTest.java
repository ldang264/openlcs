import org.junit.Assert;
import org.junit.Test;

public class Q00208mTest {

    @Test
    public void test() {
        Q00208m trie = new Q00208m();
        trie.insert("apple");
        trie.insert("add");
        Assert.assertTrue(trie.search("apple"));   // 返回 true
        Assert.assertTrue(trie.search("add"));   // 返回 true
        Assert.assertFalse(trie.search("app"));     // 返回 false
        Assert.assertFalse(trie.search("ad"));     // 返回 false
        Assert.assertFalse(trie.search("adding"));     // 返回 false
        Assert.assertFalse(trie.search("apply"));     // 返回 false
        Assert.assertTrue(trie.startsWith("app")); // 返回 true
        Assert.assertTrue(trie.startsWith("ad")); // 返回 true
        trie.insert("app");
        Assert.assertTrue(trie.search("app"));     // 返回 true

    }

}