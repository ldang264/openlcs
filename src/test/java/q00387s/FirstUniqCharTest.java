package q00387s;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstUniqCharTest {

    FirstUniqChar fuc = new FirstUniqChar();

    @Test
    public void firstUniqChar() {
        Assert.assertEquals(0, fuc.firstUniqChar("leetcode"));
        Assert.assertEquals(2, fuc.firstUniqChar("loveleetcode"));
    }
}