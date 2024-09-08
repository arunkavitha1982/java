import java.util.Scanner;

public class AVLTree {
    int data;
    int height;
    AVLTree left;
    AVLTree right;

    public AVLTree(int data) {
        this.data = data;
        this.height = 1;
    }
}

class ATree {
    static AVLTree root;

    public ATree() {
        root = null;
    }

    void inOrder(AVLTree root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println("height of " + root.data + " is " + root.height);
            // System.out.println(root.data);
            inOrder(root.right);
        }
    }

    void preOrder(AVLTree root) {
        if (root != null) {
            System.out.println("--------------------------------");
            System.out.println("Height of " + root.data + " is " + root.height);
            if (root.left != null) {
                System.out.println("The left node data is : " + root.left.data);
            } else {
                System.out.println("The left node data is : null");
            }
            if (root.right != null) {
                System.out.println("The right node data is : " + root.right.data);
            } else {
                System.out.println("Theright node data is : null");
            }
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void postOrder(AVLTree root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }

    AVLTree insertData(int val, AVLTree node) {
        if (node == null) {
            AVLTree newNode = new AVLTree(val);
            System.out.println("successfully added");
            return newNode;
        } else {
            if (val < node.data) {
                node.left = insertData(val, node.left);
            } else if (val > node.data) {
                node.right = insertData(val, node.right);
            } else {
                System.out.println("The value was already exist");
                return node;
            }
            node = updateHeightWithCheck(node, val);
            return node;
        }
    }

    AVLTree updateHeightWithCheck(AVLTree node, int value) {
        int balance = updateHeight(node);

        if (balance > 1 && node.left.data > value) {
            node = rightRotate(node);
        } else if (balance > 1 && node.left.data < value) {
            node.left = leftRotate(node.left);
            node = rightRotate(node);
        } else if (balance < -1 && node.right.data < value) {
            node = leftRotate(node);
        } else if (balance < -1 && node.right.data > value) {
            node.right = rightRotate(node.right);
            node = leftRotate(node);
        }
        return node;
    }

    static int updateHeight(AVLTree node) {
        int leftNodeHeight = node.left == null ? 0 : node.left.height;
        int rightNodeHeight = node.right == null ? 0 : node.right.height;
        node.height = (leftNodeHeight > rightNodeHeight ? leftNodeHeight : rightNodeHeight) + 1;
        return leftNodeHeight - rightNodeHeight;
    }

    AVLTree leftRotate(AVLTree node) {
        AVLTree newRoot = node.right;
        AVLTree rightNode = newRoot.left;
        newRoot.left = node;
        node.right = rightNode;
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    AVLTree rightRotate(AVLTree node) {
        AVLTree newRoot = node.left;
        AVLTree leftNode = newRoot.right;
        newRoot.right = node;
        node.left = leftNode;
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    int getBalance(AVLTree node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = node.left == null ? 0 : node.left.height;
        int rightHeight = node.right == null ? 0 : node.right.height;
        return leftHeight - rightHeight;
    }

    AVLTree delete(AVLTree root, int delValue) {
        if (root == null) {
            return null;
        }
        if (delValue < root.data) {
            root.left = delete(root.left, delValue);
        } else if (delValue > root.data) {
            root.right = delete(root.right, delValue);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                AVLTree currentNode = root.right;

                while (currentNode.left != null) {
                    currentNode = currentNode.left;
                }
                root.data = currentNode.data;
                root.right = delete(root.right, currentNode.data);
            }
        }

        int leftHeight = root.left == null ? 0 : root.left.height;
        int rightHeight = root.right == null ? 0 : root.right.height;
        root.height = (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;

        int balance = getBalance(root);
        if (balance > 1 && getBalance(root.left) > 0) {
            root = rightRotate(root);
        } else if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            root = rightRotate(root);
        } else if (balance < -1 && getBalance(root.right) < 0) {
            root = leftRotate(root);
        } else if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            root = leftRotate(root);
        }
        return root;
    }

    public static void main(String[] args) {
        ATree B1 = new ATree();

        int userInput;
        Scanner textFeild = new Scanner(System.in);
        do {
            System.out.println("---------------Binary Tree----------------");
            System.out.println("1 -> Insert Data");
            System.out.println("2 -> Show Inorder");
            System.out.println("3 -> Show Preorder");
            System.out.println("4 -> Show Postorder");
            System.out.println("5 -> delete");
            System.out.println("6 -> Exit");
            System.out.print("Enter Your Option : ");

            userInput = textFeild.nextInt();

            switch (userInput) {
                case 1:
                    System.out.print("Enter the insert value : ");
                    int insertValue = textFeild.nextInt();
                    root = B1.insertData(insertValue, root);
                    // B1.balanceCheck(root);
                    B1.preOrder(root);
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
                case 5:
                    System.out.print("Enter the del value : ");
                    int deleteValue = textFeild.nextInt();
                    root = B1.delete(root, deleteValue);
                    break;
                case 6:
                    System.out.print("Program Exiting...");
                default:
                    throw new AssertionError();
            }
        } while (userInput != 11);
    }
}
