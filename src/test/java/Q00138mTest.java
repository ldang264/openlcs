import org.junit.Test;

public class Q00138mTest {
    Q00138m crl = new Q00138m();

    @Test
    public void copyRandomList() {
        // head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Q00138m.Node head = new Q00138m.Node(7);
        Q00138m.Node n1 = new Q00138m.Node(13);
        Q00138m.Node n2 = new Q00138m.Node(11);
        Q00138m.Node n3 = new Q00138m.Node(10);
        Q00138m.Node n4 = new Q00138m.Node(1);
        head.next = n1;
        n1.next = n2;
        n1.random = head;
        n2.next = n3;
        n2.random = n4;
        n3.next = n4;
        n3.random = n2;
        n4.random = head;
        Q00138m.Node nh = crl.copyRandomList(head);
        System.out.println(nh);
    }
}