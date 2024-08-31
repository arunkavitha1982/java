import java.util.Scanner;

public class BTree {

    int data;
    int height;
    BTree left;
    BTree right;

    public BTree(int data) {
        this.data = data;
        this.height = 1;
    }
}

class AVL {

    static BTree root;

    public AVL() {
        root = null;
    }

    void inOrder(BTree root) {
        if (root != null) {
            inOrder(root.left);

            System.out.println("height of " + root.data + " is " + root.height);

            inOrder(root.right);
        }
    }

    void preOrder(BTree root) {
        if (root != null) {
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void postOrder(BTree root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }

    void insertData(int val, BTree root) {
        BTree currentNode = root;
        BTree newNode = new BTree(val);
        if (currentNode.data == val) {
            System.out.println("The root value already exists");
            return;
        } else {
            if (val < currentNode.data) {
                if (currentNode.left == null) {
                    if (currentNode.right == null) {
                        currentNode.height++;
                    }
                    currentNode.left = newNode;
                    System.out.println("The value was added to the left");
                    return;
                } else {
                    insertData(val, currentNode.left);
                    height(currentNode);
                }
            } else {
                if (currentNode.right == null) {
                    if (currentNode.left == null) {
                        currentNode.height++;
                    }
                    currentNode.right = newNode;
                    System.out.println("The value was added to the right");
                    return;
                } else {
                    insertData(val, currentNode.right);
                    height(currentNode);
                }
            }
        }
    }

    int height(BTree currentNode) {
        int leftHeight = 0;
        int rightHeight = 0;

        if (currentNode.left != null) {
            leftHeight = currentNode.left.height;
        }
        if (currentNode.right != null) {
            rightHeight = currentNode.right.height;
        }
        if (leftHeight > rightHeight) {
            currentNode.height = leftHeight + 1;
        } else {
            currentNode.height = rightHeight + 1;
        }
        return currentNode.height;
    }

    public static void main(String[] args) {
        AVL B1 = new AVL();

        int userInput;
        try (Scanner textFeild = new Scanner(System.in)) {
            do {
                System.out.println("---------------Binary Tree----------------");
                System.out.println("1 -> Insert Data");
                System.out.println("2 -> Show Inorder");
                System.out.println("3 -> Show Preorder");
                System.out.println("4 -> Show Postorder");
                System.out.println("5 -> Delete Data");
                System.out.println("6 -> Update");
                System.out.println("7 -> Exit");
                System.out.print("Enter Your Option : ");

                userInput = textFeild.nextInt();

                switch (userInput) {
                    case 1:
                        System.out.print("Enter the insert value : ");
                        int insertValue = textFeild.nextInt();
                        if (root == null) {
                            BTree newNode = new BTree(insertValue);
                            root = newNode;
                        } else {
                            B1.insertData(insertValue, root);
                        }
                        break;
                    case 2:
                        B1.inOrder(root);
                        break;
                    case 3:
                        B1.preOrder(root);
                        break;
                    case 4:
                        B1.postOrder(root);
                        break;
                    default:
                        throw new AssertionError();
                }
            } while (userInput != 5);
        } catch (AssertionError e) {

        }
    }
}
