package q00008m;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyAtoiTest {
    MyAtoi ma = new MyAtoi();

    @Test
    public void myAtoi() {
        Assert.assertEquals(42, ma.myAtoi("42"));
        Assert.assertEquals(42, ma.myAtoi("+42"));
        Assert.assertEquals(42, ma.myAtoi("   42"));
        Assert.assertEquals(-42, ma.myAtoi("   -42"));
        Assert.assertEquals(4193, ma.myAtoi("4193 with words"));
        Assert.assertEquals(0, ma.myAtoi("words and 987"));
        Assert.assertEquals(Integer.MIN_VALUE, ma.myAtoi("-2147483648"));
        Assert.assertEquals(Integer.MIN_VALUE, ma.myAtoi("-91283472332"));
        Assert.assertEquals(Integer.MAX_VALUE, ma.myAtoi("2147483648"));
        Assert.assertEquals(Integer.MAX_VALUE, ma.myAtoi("+2147483648"));
        Assert.assertEquals(Integer.MAX_VALUE, ma.myAtoi("9223372036854775808"));
    }
}