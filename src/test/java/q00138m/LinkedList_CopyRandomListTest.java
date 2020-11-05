package q00138m;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedList_CopyRandomListTest {
    LinkedList_CopyRandomList crl = new LinkedList_CopyRandomList();

    @Test
    public void copyRandomList() {
        // head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        LinkedList_CopyRandomList.Node head = new LinkedList_CopyRandomList.Node(7);
        LinkedList_CopyRandomList.Node n1 = new LinkedList_CopyRandomList.Node(13);
        LinkedList_CopyRandomList.Node n2 = new LinkedList_CopyRandomList.Node(11);
        LinkedList_CopyRandomList.Node n3 = new LinkedList_CopyRandomList.Node(10);
        LinkedList_CopyRandomList.Node n4 = new LinkedList_CopyRandomList.Node(1);
        head.next = n1;
        n1.next = n2;
        n1.random = head;
        n2.next = n3;
        n2.random = n4;
        n3.next = n4;
        n3.random = n2;
        n4.random = head;
        LinkedList_CopyRandomList.Node nh = crl.copyRandomList(head);
        System.out.println(nh);
    }
}