package ru.unn.agile.binarytree.model;

class Node {
    private  int    key;
    private  String value;

    private  Node   rightChild;
    private  Node   leftChild;

    Node(final int key, final String value) {
        this.value = value;
        this.key = key;

        this.rightChild = null;
        this.leftChild  = null;
    }

    public void setRightChild(final Node childNode) {
        this.rightChild = childNode;
    }

    public void setLeftChild(final Node childNode) {
        this.leftChild = childNode;
    }

    int getKey() {
        return key;
    };

    void set(final int key, final String value) {
        this.key = key;
        this.value = value;
    }

    String getValue() {
        return value;
    }

    Node getRightChild() {
        return rightChild;
    }

    Node getLeftChild() {
        return leftChild;
    }

    int getHeight() {
        if (rightChild == null && leftChild == null) {
            return 1;
        }
        if (rightChild == null) {
            return leftChild.getHeight() + 1;
        } else if (leftChild == null) {
            return rightChild.getHeight() + 1;
        }
        return Math.max(leftChild.getHeight(), rightChild.getHeight()) + 1;
    }

    Node getMinNode() {
        if (this.getLeftChild() != null) {
            return this.getLeftChild().getMinNode();
        }
        return this;
    }
}
