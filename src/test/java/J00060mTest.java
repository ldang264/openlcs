import org.junit.Test;

public class J00060mTest {

    J00060m_Todo j00060m = new J00060m_Todo();

    @Test
    public void dicesProbability() {
        // Assert.assertArrayEquals(j00060m.dicesProbability(1), new double[]{0.16667, 0.16667, 0.16667, 0.16667, 0.16667, 0.16667}, 5);
        // Assert.assertArrayEquals(j00060m.dicesProbability(2), new double[]{0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778}, 5);
        j00060m.dicesProbability(3);
        // Assert.assertArrayEquals(j00060m.dicesProbability(3), new double[]{0.16667, 0.16667, 0.16667, 0.16667, 0.16667, 0.16667}, 5);
    }
}