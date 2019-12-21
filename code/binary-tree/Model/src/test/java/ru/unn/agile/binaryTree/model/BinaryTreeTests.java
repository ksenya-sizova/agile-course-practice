package ru.unn.agile.binarytree.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class BinaryTreeTests {
    private BinaryTree binaryTree;
    private static Random randomGen;

    private int     simpleKey;
    private String  simpleData;

    private int arraySize;
    private int randBound;

    @Before
    public void setUp() {
        binaryTree  = new BinaryTree();

        simpleKey   = 42;
        simpleData  = "SimpleText";

        arraySize   = 10;

        randomGen   = new Random();
        randBound   = 1000;
    }

    /**
     * add tests
     */

    @Test       // add_NewData_NotNullRoot
    public void addNewDataNotNullRoot() {
        binaryTree.add(simpleKey, simpleData);

        assertNotEquals(null, binaryTree.getRootNode());
    }

    @Test       // add_SmallerDataToRoot_NotNullLeftChild
    public void addSmallerDataToRootNotNullLeftChild() {
        final int value = 10;
        final int smallerValue = 5;
        binaryTree.add(value, Integer.toString(value));

        binaryTree.add(smallerValue, Integer.toString(smallerValue));

        Node leftChild = binaryTree.getRootNode().getLeftChild();
        assertNotEquals(null, leftChild);
    }

    @Test       // add_GreaterDataToRoot_NotNullRightChild
    public void addGreaterDataToRootNotNullRightChild() {
        final int value = 10;
        final int greaterValue = 15;
        binaryTree.add(value, Integer.toString(value));

        binaryTree.add(greaterValue, Integer.toString(greaterValue));

        Node rightChild = binaryTree.getRootNode().getRightChild();
        assertNotEquals(null, rightChild);
    }

    @Test       // add_NewData_StoreCorrectRootValue
    public void addNewDataStoreCorrectRootValue() {
        binaryTree.add(simpleKey, simpleData);

        String rootValue = binaryTree.getRootNode().getValue();
        assertEquals(simpleData, rootValue);
    }

    @Test       // add_RandomValues_StoreAll
    public void addRandomValuesStoreAll() {
        int[]    inputKeys = new int[arraySize];
        String[] inputData = new String[arraySize];
        for (int i = 0; i < arraySize; ++i) {
            final int randInt = randomGen.nextInt(randBound);
            inputKeys[i] = randInt;
            inputData[i] = Integer.toString(randInt);
        }

        for (int i = 0; i < arraySize; ++i) {
            binaryTree.add(inputKeys[i], inputData[i]);
        }

        String[] resultData = new String[arraySize];
        for (int i = 0; i < arraySize; ++i) {
            resultData[i] = binaryTree.find(inputKeys[i]);
        }
        assertArrayEquals(inputData, resultData);
    }

    @Test       // add_AfterRootDelete_StoreData
    public void addAfterRootDeleteStoreData() {
        binaryTree.add(simpleKey, simpleData);
        final int    secondKey  = 2;
        final String secondData = "SecondSimpleText";

        binaryTree.remove(simpleKey);
        binaryTree.add(secondKey, secondData);

        String rootValue = binaryTree.getRootNode().getValue();
        assertEquals(secondData, rootValue);
    }

    /**
     * Find tests
     */

    @Test       // find_InEmptyTree_ReturnNull
    public void findInEmptyTreeReturnNull() {
        final String result = binaryTree.find(simpleKey);

        assertNull(result);
    }

    @Test       // find_InTreeWithData_ReturnData
    public void findInTreeWithDataReturnData() {
        binaryTree.add(simpleKey, simpleData);
        final String result = binaryTree.find(simpleKey);

        assertEquals(simpleData, result);
    }

    @Test       // find_AfterRemove_ReturnNull
    public void findAfterRemoveReturnNull() {
        binaryTree.add(simpleKey, simpleData);

        binaryTree.remove(simpleKey);
        final String result = binaryTree.find(simpleKey);

        assertNull(result);
    }

    @Test       // find_NotExistingKey_ReturnNull
    public void findNotExistingKeyReturnNull() {
        final int notExistsKey = 666;

        final String result = binaryTree.find(notExistsKey);

        assertNull(result);
    }

    /**
     * Remove tests
     */

    @Test       // remove_NotExistsKey_ReturnFalse
    public void removeNotExistsKeyReturnFalse() {
        assertFalse(binaryTree.remove(simpleKey));
    }

    @Test       // remove_ExistingKey_ReturnTrue
    public void removeExistingKeyReturnTrue() {
        binaryTree.add(simpleKey, simpleData);

        assertTrue(binaryTree.remove(simpleKey));
    }

    @Test       // remove_InTreeWithRootAndChild_RootNotNull
    public void removeInTreeWithRootAndChildRootNotNull() {
        final int rootKey   = 1;
        final int childKey  = 2;
        binaryTree.add(rootKey, Integer.toString(rootKey));
        binaryTree.add(childKey, Integer.toString(childKey));

        binaryTree.remove(rootKey);

        assertNotEquals(null, binaryTree.getRootNode());
    }

    @Test       // remove_MiddleKey_RestConnected
    public void removeMiddleKeyRestConnected() {
        final int valueOne  = 1;
        final int valueTwo  = 2;
        final int valueTree = 3;
        binaryTree.add(valueOne, Integer.toString(valueOne));
        binaryTree.add(valueTwo, Integer.toString(valueTwo));
        binaryTree.add(valueTree, Integer.toString(valueTree));

        binaryTree.remove(valueTwo);

        Node childOfTheFirst = binaryTree.getRootNode().getRightChild();
        assertNotEquals(null, childOfTheFirst);
    }

    /**
     *  getHeight tests
     */

    @Test       // getHeight_InEmptyTree_ReturnZero
    public void getHeightInEmptyTreeReturnZero() {
        assertEquals(0, binaryTree.getHeight());
    }

    @Test       // getHeight_InTreeWithOneData_ReturnOne
    public void getHeightInTreeWithOneDataReturnOne() {
        binaryTree.add(simpleKey, simpleData);
        assertEquals(1, binaryTree.getHeight());
    }

    @Test       // getHeight_InTwoValuesRightBranch_ReturnTwo
    public void getHeightInTwoValuesRightBranchReturnTwo() {
        final int amountOfValues = 2;
        final int valueOne  = 1;
        final int valueTwo  = 2;
        binaryTree.add(valueOne, Integer.toString(valueOne));
        binaryTree.add(valueTwo, Integer.toString(valueTwo));

        final int height = binaryTree.getHeight();

        assertEquals(amountOfValues, height);
    }

    @Test       // getHeight_InTwoValuesLeftBranch_ReturnTwo
    public void getHeightInTwoValuesLeftBranchReturnTwo() {
        final int amountOfValues = 2;
        final int valueOne  = 10;
        final int valueTwo  = 5;
        binaryTree.add(valueOne, Integer.toString(valueOne));
        binaryTree.add(valueTwo, Integer.toString(valueTwo));

        final int height = binaryTree.getHeight();

        assertEquals(amountOfValues, height);
    }

    @Test       // getHeight_InWithRightHighest_ReturnRightHeight
    public void getHeightInWithRightHighestReturnRightHeight() {
        final int valueRoot         = 10;
        final int valueRightFirst   = 20;
        final int valueRightSecond  = 30;
        final int valueLeftFirst    = 5;
        binaryTree.add(valueRoot, Integer.toString(valueRoot));
        binaryTree.add(valueRightFirst, Integer.toString(valueRightFirst));
        binaryTree.add(valueRightSecond, Integer.toString(valueRightSecond));
        binaryTree.add(valueLeftFirst, Integer.toString(valueLeftFirst));

        final int resultHeight = binaryTree.getHeight();

        final int expectedHeight = 3;
        assertEquals(expectedHeight, resultHeight);
    }
}
