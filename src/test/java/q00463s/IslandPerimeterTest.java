package q00463s;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IslandPerimeterTest {

    private IslandPerimeter ip = new IslandPerimeter();

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
    }
}