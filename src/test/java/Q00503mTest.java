import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Q00503mTest {

    Q00503m q00503m = new Q00503m();

    @Test
    public void nextGreaterElements() {
        Assert.assertEquals(Arrays.toString(q00503m.nextGreaterElements(new int[]{2, 3, 1})), "[3, -1, 2]");
        Assert.assertEquals(Arrays.toString(q00503m.nextGreaterElements(new int[]{1, 2, 3, 2, 1})), "[2, 3, -1, 3, 2]");
        Assert.assertEquals(Arrays.toString(q00503m.nextGreaterElements(new int[]{1, 1, 1})), "[-1, -1, -1]");
        Assert.assertEquals(Arrays.toString(q00503m.nextGreaterElements(new int[]{1, 1, 2})), "[2, 2, -1]");
        Assert.assertEquals(Arrays.toString(q00503m.nextGreaterElements(new int[]{1, 2, 1})), "[2, -1, 2]");
        Assert.assertEquals(Arrays.toString(q00503m.nextGreaterElements(new int[]{1, 2, 2})), "[2, -1, -1]");
        Assert.assertEquals(Arrays.toString(q00503m.nextGreaterElements(new int[]{2, 1, 1})), "[-1, 2, 2]");
        Assert.assertEquals(Arrays.toString(q00503m.nextGreaterElements(new int[]{2, 2, 1})), "[-1, -1, 2]");
        Assert.assertEquals(Arrays.toString(q00503m.nextGreaterElements(new int[]{1, 2, 3})), "[2, 3, -1]");
        Assert.assertEquals(Arrays.toString(q00503m.nextGreaterElements(new int[]{1, 3, 2})), "[3, -1, 3]");
        Assert.assertEquals(Arrays.toString(q00503m.nextGreaterElements(new int[]{2, 1, 3})), "[3, 3, -1]");
        Assert.assertEquals(Arrays.toString(q00503m.nextGreaterElements(new int[]{3, 1, 2})), "[-1, 2, 3]");
        Assert.assertEquals(Arrays.toString(q00503m.nextGreaterElements(new int[]{3, 2, 1})), "[-1, 3, 3]");
    }
}