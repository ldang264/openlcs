package q01356s;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortByBitsTest {

    SortByBits sbb = new SortByBits();

    @Test
    public void sortByBits() {
        Assert.assertEquals("[0, 1, 2, 4, 8, 3, 5, 6, 7]",
                Arrays.toString(sbb.sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
        Assert.assertEquals("[1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024]",
                Arrays.toString(sbb.sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})));
        Assert.assertEquals("[10000, 10000]",
                Arrays.toString(sbb.sortByBits(new int[]{10000, 10000})));
        Assert.assertEquals("[2, 3, 5, 17, 7, 11, 13, 19]",
                Arrays.toString(sbb.sortByBits(new int[]{2, 3, 5, 7, 11, 13, 17, 19})));
        Assert.assertEquals("[10, 100, 10000, 1000]",
                Arrays.toString(sbb.sortByBits(new int[]{10, 100, 1000, 10000})));
    }
}