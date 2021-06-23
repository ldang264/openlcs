import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Q00648mTest {

    Q00648m q00648m = new Q00648m();

    @Test
    public void replaceWords() {
        Assert.assertEquals(q00648m.replaceWords(Arrays.asList("hb", "hbld", "hoq"), "hgo"), "hgo");
        Assert.assertEquals(q00648m.replaceWords(Arrays.asList("cat", "bat", "rat"), "the r was rattled by the battery"), "the r was rat by the bat");
        Assert.assertEquals(q00648m.replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"), "the cat was rat by the bat");
        Assert.assertEquals(q00648m.replaceWords(Arrays.asList("a", "b", "c"), "aadsfasf absbs bbab cadsfafs"), "a a b c");
        Assert.assertEquals(q00648m.replaceWords(Arrays.asList("a", "aa", "aaa", "aaaa"), "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"), "a a a a a a a a bbb baba a");
        Assert.assertEquals(q00648m.replaceWords(Arrays.asList("catt", "cat", "bat", "rat"), "the cattle was rattled by the battery"), "the cat was rat by the bat");
        Assert.assertEquals(q00648m.replaceWords(Arrays.asList("ac", "ab"), "it is abnormal that this solution is accepted"), "it is ab that this solution is ac");
    }
}