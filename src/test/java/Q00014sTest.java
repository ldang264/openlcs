import org.junit.Test;

import static org.junit.Assert.*;

public class Q00014sTest {

    Q00014s lcp = new Q00014s();

    @Test
    public void longestCommonPrefix() {
        System.out.println(lcp.longestCommonPrefix(new String[]{"ab","a"}));
        System.out.println(lcp.longestCommonPrefix(new String[]{}));
        System.out.println(lcp.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(lcp.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}