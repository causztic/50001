package week5.partb;

/**
 * Created by yaojie on 25/10/17.
 */

public class ArrayOfTrees {

    class Node {
        String value;
        int occurrences;
        Node left;
        Node right;

        private Node(String value){
            this.value = value;
            occurrences = 1;
            left = null;
            right = null;
        }

        private void increment(){
            occurrences++;
        }

        // Attempt to add to the tree.
        // If they are equal, increment the occurrence count
        // Otherwise put left or right depending on string.
        private void addItem(String word){
            if (value.compareToIgnoreCase(word) == 0){
                increment();
            } else if (value.compareTo(word) > 0){
                if (left == null)
                    left = new Node(word);
                else
                    left.addItem(word);
            } else {
                if (right == null)
                    right = new Node(word);
                else
                    right.addItem(word);
            }
        }

        private void inOrderTraversal(){
            inOrderTraversal(this);
        }

        private void inOrderTraversal(Node n){
            if (n.left != null)
                inOrderTraversal(n.left);
            System.out.printf("%s (%d) ", n.value, n.occurrences);
            if (n.right != null)
                inOrderTraversal(n.right);
        }
    }

    Node[] trees = new Node[26];

    public ArrayOfTrees(String input){
        for(String word: input.split(" ")){
            // 97 is a. set that as the first item in the array.
            // ignore if word is not a letter.
            if (Character.isLetter(word.toLowerCase().charAt(0))){
                int index = (int) word.toLowerCase().charAt(0) - 97;
                if (trees[index] == null)
                    trees[index] = new Node(word);
                else
                    trees[index].addItem(word);
            }

        }
    }

    public void inOrderTraversal(){
        for (Node tree: trees){
            if (tree != null){
                System.out.println("\nInorder Traversal: ");
                tree.inOrderTraversal();
            }
        }
    }

    public static void main(String[] args) {
        String input = "This is a piece of text from which hopefully you will make some trees. ";
        ArrayOfTrees aot = new ArrayOfTrees(input);
        aot.inOrderTraversal();
    }
}
