import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00146mTest {

    @Test
    public void test1() {
        Q00146m cache = new Q00146m( 2 /* 缓存容量 */ );
        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(1, cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        Assert.assertEquals(-1, cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        Assert.assertEquals(-1, cache.get(1));       // 返回 -1 (未找到)
        Assert.assertEquals(3, cache.get(3));       // 返回  3
        Assert.assertEquals(4, cache.get(4));       // 返回  4
    }

    @Test
    public void test2() {
        Q00146m cache = new Q00146m( 2 /* 缓存容量 */ );
        cache.put(1, 0);
        cache.put(2, 2);
        Assert.assertEquals(0, cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        Assert.assertEquals(-1, cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        Assert.assertEquals(-1, cache.get(1));       // 返回 -1 (未找到)
        Assert.assertEquals(3, cache.get(3));       // 返回  3
        Assert.assertEquals(4, cache.get(4));       // 返回  4
    }

    @Test
    public void test3() {
        Q00146m cache = new Q00146m( 2 /* 缓存容量 */ );
        Assert.assertEquals(-1, cache.get(2));       // 返回  -1 (未找到)
        cache.put(2, 6);
        Assert.assertEquals(-1, cache.get(1));       // 返回  -1 (未找到)
        cache.put(1, 5);
        cache.put(1, 2);
        Assert.assertEquals(2, cache.get(1));       // 返回  1
        Assert.assertEquals(6, cache.get(2));       // 返回  6
    }

}