class Node {

    // data stores an integer value
    // whereas left & right are two nodes, which from the beginning are just Null
    // by default this node always points to two more nodes which, if they don't exist, are just Null
    int data;
    Node left;
    Node right;

    // on creation, a node will only have an Int data
    public Node(int data) {
        this.data = data;

    }
}

// the Binary Tree is tasked with giving the nodes left & right data, which will transition them from being Null
// to being a Node that holds an Int and has two more Null nodes(lef & right)
public class BinaryTree {
    Node root;

    public void addNode(int data) {
        // this method has been created mainly to initialise a recursive function which will then call itself
        root = addNodeRecursive(root, data);
    }

    private Node addNodeRecursive(Node current, int data) {
        //If current node is null, create a new node with the given data and return it
        if (current == null){
            return new Node(data);
        }

        // If the given data is less than the current node's data,
        // add the new node to the left side of the current node
        if (data < current.data) {
            current.left = addNodeRecursive(current.left, data);
        }

        // If the given data is greater than the current node's data,
        // add the new node to the right side of the current node
        else if (data > current.data) {
            current.right = addNodeRecursive(current.right, data);
        }

        // If the value already exists in the tree, return the current node
        else {
            return current;
        }
        return current;
    }

    public boolean containsNode(int data) {
        // this method has been created mainly to initialise a recursive function which will then call itself
        return containsNodeRecursive(root, data);
    }

    private boolean containsNodeRecursive(Node current, int data){

        // usually this first condition will be met after going through the tree
        // if it doesn't find the value, it will get to a Node that is null/contains null Data
        if (current == null) {
            return false;
        }

        // usually this condition will be met after going through the tree
        // if it does find the value, it will get to a Node that has Data equal to the given data
        if (data == current.data) {
            return true;
        }


        // if the data argument is smaller than the current node's data, will go to the left node
        // otherwise it'll go right
        // obviously if it's equal, it should be taken care by the previous if statement
        return data < current.data
                ? containsNodeRecursive(current.left, data)
                : containsNodeRecursive(current.right, data);
    }

    public void deleteNode(int data){
        //deleting node from the binary search tree
        root = deleteNodeRecursive(root, data);
    }

    private Node deleteNodeRecursive(Node current, int data){
        //check if current node is null, return null
        if (current == null){
            return null;
        }
        //check if current node has the data to be deleted
        if (data == current.data){
            //current node has no child
            if (current.left == null && current.right == null){
                return null;
            }
            //current node has only left child
            if (current.right == null){
                return current.left;
            }
            //current node has only right child
            if (current.left == null){
                return current.right;
            }
            //current node has both left and right child
            //find the smallest value in the right subtree
            int smallestValue = findSmallestValue(current.right);
            //replace current node data with the smallest value
            current.data = smallestValue;
            //delete the node with the smallest value in the right subtree
            current.right = deleteNodeRecursive(current.right, smallestValue);
            //return the current node after deleting the smallest value node
            return current;
        }
        //recursively delete node in the left subtree if data is less than current node data
        if (data < current.data) {
            current.left = deleteNodeRecursive(current.left, data);
            return current;
        }
        //recursively delete node in the right subtree if data is greater than current node data
        current.right = deleteNodeRecursive(current.right, data);
        return current;
    }

    private int findSmallestValue(Node root) {
        //return root data if left child is null
        //otherwise find the smallest value in the left subtree
        return root.left == null ? root.data : findSmallestValue(root.left);
    }



}
