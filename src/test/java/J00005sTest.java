import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class J00005sTest {

    J00005s j00005s = new J00005s();

    @Test
    public void replaceSpace() {
        Assert.assertEquals(j00005s.replaceSpace(""), "");
        Assert.assertEquals(j00005s.replaceSpace("We  are happy."), "We%20%20are%20happy.");
        Assert.assertEquals(j00005s.replaceSpace("We are happy."), "We%20are%20happy.");
    }
}