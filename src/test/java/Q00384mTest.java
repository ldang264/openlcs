import org.junit.Test;

import java.util.Arrays;

public class Q00384mTest {

    @Test
    public void test() {
        Q00384m q00384m = new Q00384m(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(q00384m.shuffle()));
        System.out.println(Arrays.toString(q00384m.reset()));
        System.out.println(Arrays.toString(q00384m.shuffle()));
    }

}