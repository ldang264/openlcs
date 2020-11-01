package q00381h;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class RandomizedCollectionTest extends TestCase {

    @Test
    public void test() {
        RandomizedCollection obj = new RandomizedCollection();
        boolean param1 = obj.insert(1);
        Assert.assertTrue(param1);
        boolean param2 = obj.insert(1);
        Assert.assertFalse(param2);
        boolean param3 = obj.insert(2);
        Assert.assertTrue(param3);
        int value1 = obj.getRandom();
        boolean param4 = obj.remove(1);
        Assert.assertTrue(param4);
        int value2 = obj.getRandom();
        System.out.println();
    }

    @Test
    public void test1() {
        RandomizedCollection obj = new RandomizedCollection();
        boolean param1 = obj.insert(0);
        Assert.assertTrue(param1);
        boolean param2 = obj.insert(0);
        Assert.assertFalse(param2);
        boolean param3 = obj.insert(2);
        Assert.assertTrue(param3);
        int value1 = obj.getRandom();
        System.out.println(value1);
        param1 = obj.insert(3);
        Assert.assertTrue(param1);
        value1 = obj.getRandom();
        System.out.println(value1);
        param1 = obj.insert(3);
        Assert.assertFalse(param1);
        value1 = obj.getRandom();
        System.out.println(value1);
        param1 = obj.insert(2);
        Assert.assertFalse(param1);
    }

    @Test
    public void test2() {
        RandomizedCollection obj = new RandomizedCollection();
        boolean param1 = obj.insert(1);
        Assert.assertTrue(param1);
        boolean param2 = obj.insert(1);
        Assert.assertFalse(param2);
        boolean param3 = obj.insert(2);
        Assert.assertTrue(param3);
        boolean param4 = obj.insert(1);
        Assert.assertFalse(param4);
        boolean param5 = obj.insert(2);
        Assert.assertFalse(param5);
        boolean param6 = obj.insert(2);
        Assert.assertFalse(param6);
        boolean param7 = obj.remove(1);
        Assert.assertTrue(param7);
        param7 = obj.remove(2);
        Assert.assertTrue(param7);
        param7 = obj.remove(2);
        Assert.assertTrue(param7);
        param7 = obj.remove(2);
        Assert.assertTrue(param7);
        int value1 = obj.getRandom();
        Assert.assertEquals(1, value1);
        value1 = obj.getRandom();
        Assert.assertEquals(1, value1);
        value1 = obj.getRandom();
        Assert.assertEquals(1, value1);
        value1 = obj.getRandom();
        Assert.assertEquals(1, value1);
        System.out.println();
    }
}