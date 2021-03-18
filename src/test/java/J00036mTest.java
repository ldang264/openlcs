import org.junit.Test;

import static org.junit.Assert.*;

public class J00036mTest {

    J00036m j00036m = new J00036m();

    @Test
    public void treeToDoublyList() {
        J00036m.Node root = new J00036m.Node(4);
        root.left = new J00036m.Node(2);
        root.right = new J00036m.Node(5);
        root.left.left = new J00036m.Node(1);
        root.left.right = new J00036m.Node(3);
        J00036m.Node node = j00036m.treeToDoublyList(root);
        System.out.println(node);
    }

    @Test
    public void treeToDoublyList1() {
        J00036m.Node root = new J00036m.Node(-1);
        root.right = new J00036m.Node(1);
        root.right.right = new J00036m.Node(9);
        J00036m.Node node = j00036m.treeToDoublyList(root);
        System.out.println(node);
    }
}