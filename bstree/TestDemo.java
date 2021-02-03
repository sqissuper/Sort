package bstree;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2021-02-03
 * Time: 11:26
 */


class BinarySearchTree {

    static class BSNode {
        public int val;
        public BSNode left;
        public BSNode right;
        public BSNode(int val) {
            this.val = val;
        }
    }
    public BSNode root = null;

    public BSNode search(int val) {
        if(root == null) return null;
        BSNode cur = root;
        while (cur != null) {
            if(cur.val == val) {
                return cur;
            }else if(cur.val < val) {
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        return null;
    }

    public boolean insert(int val) {
        BSNode bsNode = new BSNode(val);
        if(root == null) {
            root = bsNode;
            return true;
        }
        BSNode cur = root;
        BSNode parent = null;

        while (cur != null) {
            if(cur.val == val) {
                return false;
            }else if(cur.val < val) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
        //
        if(parent.val < val) {
            parent.right = bsNode;
        }else {
            parent.left = bsNode;
        }
        return true;
    }


    public void remove(int val) {

    }




}
public class TestDemo {


    public static void preOrder(BinarySearchTree.BSNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(BinarySearchTree.BSNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(4);
        binarySearchTree.insert(3);
        binarySearchTree.insert(1);
        binarySearchTree.insert(15);
        binarySearchTree.insert(11);

        preOrder(binarySearchTree.root);
        System.out.println();
        inOrder(binarySearchTree.root);
        System.out.println();

        try {
            BinarySearchTree.BSNode ret = binarySearchTree.search(14);
            System.out.println(ret.val);
        }catch (NullPointerException e) {
            System.out.println("没有找到当前的节点............");
            e.printStackTrace();
        }

    }
}
