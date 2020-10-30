package code.jdk;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class HashMapTest {

    @Test
    public void testHashMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "nancy");
        Assert.assertEquals(map.get("name"), "nancy");
        map.put("name", "daniel");
        Assert.assertEquals(map.get("name"), "daniel");
        map.put("address", "上海");
        map.put("age", "30");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        map.put("ten", "10");
        map.put("elven", "11");
        Assert.assertEquals(14, map.size());
    }
}
