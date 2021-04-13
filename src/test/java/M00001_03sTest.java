import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class M00001_03sTest {

    M00001_03s m00001_03s = new M00001_03s();

    @Test
    public void replaceSpaces() {
        Assert.assertEquals(m00001_03s.replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27), "ds%20sdfs%20afs%20sdfa%20dfssf%20asdf");
        Assert.assertEquals(m00001_03s.replaceSpaces("Mr John Smith    ", 13), "Mr%20John%20Smith");
        Assert.assertEquals(m00001_03s.replaceSpaces("               ", 5), "%20%20%20%20%20");
        Assert.assertEquals(m00001_03s.replaceSpaces("", 0), "");
        Assert.assertEquals(m00001_03s.replaceSpaces("M", 1), "M");
        Assert.assertEquals(m00001_03s.replaceSpaces("Mr", 2), "Mr");
        Assert.assertEquals(m00001_03s.replaceSpaces("   ", 1), "%20");
    }
}