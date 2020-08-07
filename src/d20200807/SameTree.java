package d20200807;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    public static void main(String[] args) {
        test3();
    }

    private static void test1() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        SameTree st = new SameTree();
        System.out.println(st.isSameTree(p, q));
    }

    private static void test2() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);
        SameTree st = new SameTree();
        System.out.println(st.isSameTree(p, q));
    }

    private static void test3() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(1);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);
        SameTree st = new SameTree();
        System.out.println(st.isSameTree(p, q));
    }

/*
    private boolean isLeftSame(TreeNode pl, TreeNode ql) {
        if (pl == null && ql == null) {
            return true;
        }
        if (pl != null && ql != null) {
            return
        }
    }

    private boolean isRightSame(TreeNode pr, TreeNode qr) {
        while(pl != null && ql != null && pl.left != ql.left)
    }*/
}
