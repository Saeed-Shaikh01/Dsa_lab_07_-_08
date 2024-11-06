/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package project.binary_tree;

/**
 *
 * @author sys
 */
  

import java.util.LinkedList;
import java.util.Queue;

public class Binary_Tree {

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = insertRec(current.left, value);
        } else if (value > current.value) {
            current.right = insertRec(current.right, value);
        }
        return current;
    }

    public int countNodes() {
        return countNodesRec(root);
    }

    private int countNodesRec(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodesRec(node.left) + countNodesRec(node.right);
    }

    public void levelOrderTraversal() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        System.out.println();
    }

    public void preOrderTraversal(Node node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void inOrderTraversal(Node node) {
        if (node == null) return;
        inOrderTraversal(node.left);
        System.out.print(node.value + " ");
        inOrderTraversal(node.right);
    }

    public void postOrderTraversal(Node node) {
        if (node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.value + " ");
    }

    public static void main(String[] args) {
        Binary_Tree tree = new Binary_Tree();
        int[] elements = {50, 30, 20, 40, 70, 60, 80};
        for (int value : elements) {
            tree.insert(value);
            System.out.println("Inserted " + value + ", Total nodes: " + tree.countNodes());
        }

        System.out.println("\nLevel-order Traversal:");
        tree.levelOrderTraversal();

        System.out.println("Pre-order Traversal:");
        tree.preOrderTraversal(tree.root);
        System.out.println();

        System.out.println("In-order Traversal:");
        tree.inOrderTraversal(tree.root);
        System.out.println();

        System.out.println("Post-order Traversal:");
        tree.postOrderTraversal(tree.root);
        System.out.println();
    }
}
