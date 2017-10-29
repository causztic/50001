package week5.partb;

/**
 * Created by yaojie on 23/10/17.
 */


public class TrinarySearchTree {

    private Node root;

    class Node {
        protected int leftData, rightData;
        protected Node left, middle, right;

        public Node() {
            leftData = -1;
            rightData = -1;
            left = null;
            middle = null;
            right = null;
        }

        public void setData(int value){
            //if any of the data are not set
            if (leftData == -1 && rightData == -1){
                // both are unset, set to leftData
                leftData = value;
            } else if (leftData > value){
                // left is bigger than the value,
                rightData = leftData;
                leftData = value;
            } else {
                // left is smaller than the value;
                rightData = value;
            }
        }

        public boolean isFull(){
            return leftData != -1 && rightData != -1;
        }

        /*
            Compares the data with the input.
            @param  value   takes in the value to check against.
            @return 0 if smaller than two
                    1 if in between
                    2 if bigger
         */
        public int compareData(int value){
            if (rightData > value)
                if (leftData > value)
                    return 0;
                else
                    return 1;
            else
                return 2;
        }
    }

    public void setChild(Node node, int value){
        if (node.isFull()){
            // if it's full, set the child recursively.
            switch (node.compareData(value)){
                case 0:
                    // smaller
                    if (node.left == null){
                        node.left = new Node();
                        node.left.setData(value);
                    } else {
                        setChild(node.left, value);
                    }
                    break;
                case 1:
                    // in between
                    if (node.middle == null){
                        node.middle = new Node();
                        node.middle.setData(value);
                    } else {
                        setChild(node.middle, value);
                    }
                    break;
                case 2:
                    // bigger
                    if (node.right == null){
                        node.right = new Node();
                        node.right.setData(value);
                    } else {
                        setChild(node.right, value);
                    }
                    break;
            }
        } else {
            // node is not completely filled up yet, fill data.
            node.setData(value);
        }
    }

    public TrinarySearchTree(int[] values){
        // construct the tree based on input.

        if (values.length > 0){
            root = new Node();
            for (int i = 0; i < values.length; i++){
                setChild(root, values[i]);
            }
        }
    }

    // ROOT, LEFT, MIDDLE, RIGHT
    public void preOrderTraversal(){
        preOrderTraversal(root);
    }
    public void preOrderTraversal(Node n){
        System.out.printf(" %d %d : ", n.leftData, n.rightData);
        if (n.left != null)
            preOrderTraversal(n.left);
        if (n.middle != null)
            preOrderTraversal(n.middle);
        if (n.right != null)
            preOrderTraversal(n.right);
    }

    // LEFT, MIDDLE, ROOT, RIGHT
    public void inOrderTraversal(){
        inOrderTraversal(root);
    }

    public void inOrderTraversal(Node n){
        if (n.left != null)
            inOrderTraversal(n.left);
        System.out.printf(" %d : ", n.leftData);
        if (n.middle != null)
            inOrderTraversal(n.middle);
        System.out.printf(" %d :", n.rightData);
        if (n.right != null)
            inOrderTraversal(n.right);
    }

    // LEFT, MIDDLE, RIGHT, ROOT
    public void postOrderTraversal(){
        postOrderTraversal(root);
    }

    public void postOrderTraversal(Node n){
        if (n.left != null)
            postOrderTraversal(n.left);
        if (n.middle != null)
            postOrderTraversal(n.middle);
        if (n.right != null)
            postOrderTraversal(n.right);
        System.out.printf(" %d %d : ", n.leftData, n.rightData);
    }

    public int search(int x){
        return search(root, x, 0);
    }

    /*
        @return the depth. it will return -1 if it is not found.
     */
    public int search(Node n, int x, int depth){

        // if found on the current, return the depth.
        if (n.leftData == x || n.rightData == x)
            return depth;

        switch(n.compareData(x)){
            case 0:
                // smaller
                return n.left != null ? search(n.left, x, ++depth) : -1;
            case 1:
                // in between
                return n.middle != null ? search(n.middle, x, ++depth) : -1;
            case 2:
                // bigger
                return n.right != null ? search(n.right, x, ++depth) : -1;
            default:
                return -1;
        }
    }

    public int findMin(){
        return findMin(root);
    }

    public int findMin(Node n){
        if (n.left != null)
            return findMin(n.left);
        else
            return n.leftData;
    }

    public int findMax(){
        return findMax(root);
    }

    public int findMax(Node n){
        if (n.right != null)
            return findMax(n.right);
        else
            return n.rightData;
    }

    public static void main(String[] args) {
        int[] num = {100, 200, 590, 70, 80, 360, 110, 105, 102,107};
        TrinarySearchTree tst = new TrinarySearchTree(num);

        System.out.println("PreOrder Traversal: ");
        tst.preOrderTraversal();

        System.out.println("\nInOrder Traversal: ");
        tst.inOrderTraversal();

        System.out.println("\nPostOrder Traversal: ");
        tst.postOrderTraversal();
        int[] searchItems = { 100, 590, 107, 300 };

        System.out.println();

        for (int term: searchItems){
            int result = tst.search(term);
            if (result == -1)
                System.out.printf("Result not found for %d\n", term);
            else
                System.out.printf("Found %d at depth %d\n", term, result);
        }

        System.out.println("Minimum value: " + tst.findMin());
        System.out.println("Maximum value: " + tst.findMax());
    }
}
