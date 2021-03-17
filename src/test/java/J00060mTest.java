import org.junit.Assert;
import org.junit.Test;

public class J00060mTest {

    J00060m j00060m = new J00060m();

    @Test
    public void dicesProbability() {
        Assert.assertArrayEquals(j00060m.dicesProbability(4),new double[]{0.00077, 0.00309, 0.00772, 0.01543, 0.02701, 0.04321, 0.06173, 0.08025, 0.09645, 0.10802, 0.11265, 0.10802, 0.09645, 0.08025, 0.06173, 0.04321, 0.02701, 0.01543, 0.00772, 0.00309, 0.00077}, 5);
    }
}