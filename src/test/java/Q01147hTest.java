import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q01147hTest {

    Q01147h q01147h = new Q01147h();

    @Test
    public void longestDecomposition() {
        // nufbkf|lwjj|lwjj|nufbkf
        Assert.assertEquals(q01147h.longestDecomposition("nufbkflwjjlwjjnufbkf"), 4);
        // nyrgleggdmyu|rxcl|zdy|y|y|zdy|rxcl|nyrgleggdmyu
        Assert.assertEquals(q01147h.longestDecomposition("nyrgleggdmyurxclzdyyyzdyrxclnyrgleggdmyu"), 8);
        Assert.assertEquals(q01147h.longestDecomposition("ghiabcdefhelloadamhelloabcdefghi"), 7);
        Assert.assertEquals(q01147h.longestDecomposition("merchant"), 1);
        Assert.assertEquals(q01147h.longestDecomposition("aaa"), 3);
        Assert.assertEquals(q01147h.longestDecomposition("antaprezatepzapreanta"), 11);
    }
}