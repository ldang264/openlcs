import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00722mTest {

    Q00722m q00722m = new Q00722m();

    @Test
    public void removeComments() {
        Assert.assertEquals(q00722m.removeComments(new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"}).toString(), "");
    }
}