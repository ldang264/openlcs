import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class M00016_02mTest {


    @Test
    public void test() {
        M00016_02m wordsFrequency = new M00016_02m(new String[]{"i", "have", "an", "apple", "he", "have", "a", "pen"});
        Assert.assertEquals(wordsFrequency.get("you"), 0); //返回0，"you"没有出现过
        Assert.assertEquals(wordsFrequency.get("have"), 2); //返回2，"have"出现2次
        Assert.assertEquals(wordsFrequency.get("an"), 1); //返回1
        Assert.assertEquals(wordsFrequency.get("apple"), 1); //返回1
        Assert.assertEquals(wordsFrequency.get("pen"), 1); //返回1
    }

}