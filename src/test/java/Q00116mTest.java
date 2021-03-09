import org.junit.Test;

import static org.junit.Assert.*;

public class Q00116mTest {

    Q00116m q00116m = new Q00116m();

    @Test
    public void connect1() {
        Q00116m.Node n21 = new Q00116m.Node(2);
        Q00116m.Node n22 = new Q00116m.Node(3);
        Q00116m.Node n11 = new Q00116m.Node(1, n21, n22);
        q00116m.connect(n11);
        System.out.println(1);
    }

    @Test
    public void connect2() {
        Q00116m.Node n31 = new Q00116m.Node(4);
        Q00116m.Node n32 = new Q00116m.Node(5);
        Q00116m.Node n33 = new Q00116m.Node(6);
        Q00116m.Node n34 = new Q00116m.Node(7);
        Q00116m.Node n21 = new Q00116m.Node(2, n31, n32);
        Q00116m.Node n22 = new Q00116m.Node(3, n33, n34);
        Q00116m.Node n11 = new Q00116m.Node(1, n21, n22);
        q00116m.connect(n11);
        System.out.println(1);
    }

    @Test
    public void connect3() {
        Q00116m.Node n41 = new Q00116m.Node(8);
        Q00116m.Node n42 = new Q00116m.Node(9);
        Q00116m.Node n43 = new Q00116m.Node(10);
        Q00116m.Node n44 = new Q00116m.Node(11);
        Q00116m.Node n45 = new Q00116m.Node(12);
        Q00116m.Node n46 = new Q00116m.Node(13);
        Q00116m.Node n47 = new Q00116m.Node(14);
        Q00116m.Node n48 = new Q00116m.Node(15);
        Q00116m.Node n31 = new Q00116m.Node(4, n41, n42);
        Q00116m.Node n32 = new Q00116m.Node(5, n43, n44);
        Q00116m.Node n33 = new Q00116m.Node(6, n45, n46);
        Q00116m.Node n34 = new Q00116m.Node(7, n47, n48);
        Q00116m.Node n21 = new Q00116m.Node(2, n31, n32);
        Q00116m.Node n22 = new Q00116m.Node(3, n33, n34);
        Q00116m.Node n11 = new Q00116m.Node(1, n21, n22);
        q00116m.connect(n11);
        System.out.println(1);
    }

}