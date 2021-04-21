import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Q00133mTest {

    Q00133m q00133m = new Q00133m();

    @Test
    public void cloneGraph() {
        Q00133m.Node one = new Q00133m.Node();
        one.val = 1;
        Q00133m.Node two = new Q00133m.Node();
        two.val = 2;
        Q00133m.Node three = new Q00133m.Node();
        three.val = 3;
        Q00133m.Node four = new Q00133m.Node();
        four.val = 4;
        List<Q00133m.Node> ones = Arrays.asList(two, four);
        List<Q00133m.Node> twos = Arrays.asList(one, three);
        List<Q00133m.Node> threes = Arrays.asList(two, four);
        List<Q00133m.Node> fours = Arrays.asList(one, three);
        one.neighbors = ones;
        two.neighbors = twos;
        three.neighbors = threes;
        four.neighbors = fours;
        Q00133m.Node head = q00133m.cloneGraph(one);
        System.out.println(head);
    }
}