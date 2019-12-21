package ru.unn.agile.binarytree.model;

public class BinaryTree {
    private Node rootNode = null;

    public void add(final int key, final String value) {
        if (rootNode == null) {
            rootNode = new Node(key, value);
        } else {
            addChild(rootNode, new Node(key, value));
        }
    }

    public String find(final int key) {
        Node foundNode = findNode(rootNode, key);
        if (foundNode == null) {
            return null;
        }
        return foundNode.getValue();
    }

    private static Node findNode(final Node root, final int key) {
        if (root == null) {
            return null;
        }
        if (root.getKey() == key) {
            return root;
        }
        if (root.getRightChild() == null && root.getLeftChild() == null) {
            return null;
        }
        if (key > root.getKey()) {
            return findNode(root.getRightChild(), key);
        } else {
            return findNode(root.getLeftChild(), key);
        }
    }

    public boolean remove(final int key) {
        Node temp = findNode(rootNode, key);
        if (temp == null) {
            return false;
        } else {
            rootNode = removeRecursive(rootNode, key);
            return true;
        }
    }

    private Node removeRecursive(final Node root, final int key) {
        if (root == null) {
            return null;
        }
        if (key > root.getKey()) {
            Node newRight = removeRecursive(root.getRightChild(), key);
            root.setRightChild(newRight);
        } else if (key < root.getKey()) {
            Node newLeft = removeRecursive(root.getLeftChild(), key);
            root.setLeftChild(newLeft);
        } else {
            if (root.getLeftChild() == null) {
                return root.getRightChild();
            } else if (root.getRightChild() == null) {
                return root.getLeftChild();
            } else {
                Node minNode = rootNode.getRightChild().getMinNode();
                root.set(minNode.getKey(), minNode.getValue());

                removeRecursive(root.getRightChild(), minNode.getKey());
            }
        }
        return root;
    }

    private static void addChild(final Node root, final Node childNode) {
        if (childNode.getKey() > root.getKey()) {
            if (root.getRightChild() != null) {
                addChild(root.getRightChild(), childNode);
            } else {
                root.setRightChild(childNode);
            }
        } else if (childNode.getKey() < root.getKey()) {
            if (root.getLeftChild() != null) {
                addChild(root.getLeftChild(), childNode);
            } else {
                root.setLeftChild(childNode);
            }
        } else {
            root.set(childNode.getKey(), childNode.getValue());
        }
    }

    Node getRootNode() {
        return rootNode;
    }

    public int getHeight() {
        if (rootNode != null) {
            return rootNode.getHeight();
        } else {
            return 0;
        }
    }
}
