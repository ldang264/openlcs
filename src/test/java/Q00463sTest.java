import ans.Q00463s_Ans;
import org.junit.Assert;
import org.junit.Test;

public class Q00463sTest {

    private Q00463s ip = new Q00463s();

    private Q00463s_Ans ipa = new Q00463s_Ans();

    @Test
    public void islandPerimeter() {
        Assert.assertEquals(4, ip.islandPerimeter(new int[][]{
                {0, 0, 0},
                {0, 1, 0}
        }));
    }

    @Test
    public void islandPerimeter1() {
        Assert.assertEquals(4, ip.islandPerimeter(new int[][]{
                {1}
        }));
    }

    @Test
    public void islandPerimeter2() {
        Assert.assertEquals(16, ip.islandPerimeter(new int[][]{
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        }));
        Assert.assertEquals(16, ipa.islandPerimeter(new int[][]{
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        }));
    }
}