package algorithm.tree;

import org.junit.Test;
import tool.TreeNode;

/**
* 深度优先测试用例
*/
public class DFSTest {

    DFS dfs = new DFS();

    /**
     *      1
     *     / \
     *    2   3
     *    \    \
     *     4    5
     *
     */
    TreeNode root = TreeNode.deserialize("1,2,3,null,4,null,5");

    @Test
    public void dfs_iteration_preorder() {
        dfs.dfs_iteration_preorder(root); // 1 2 4 3 5
        System.out.println();
    }

    @Test
    public void dfs_iteration_inorder() {
        dfs.dfs_iteration_inorder(root); // 2 4 1 3 5
        System.out.println();
    }

    @Test
    public void dfs_iteration_postorder() {
        dfs.dfs_iteration_postorder(root); // 4 2 5 3 1
        System.out.println();
    }

    @Test
    public void dfs_recursion_preorder() {
        dfs.dfs_recursion_preorder(root); // 1 2 4 3 5
        System.out.println();
    }

    @Test
    public void dfs_recursion_inorder() {
        dfs.dfs_recursion_inorder(root); // 2 4 1 3 5
        System.out.println();
    }

    @Test
    public void dfs_recursion_postorder() {
        dfs.dfs_recursion_postorder(root); // 4 2 5 3 1
        System.out.println();
    }
}
