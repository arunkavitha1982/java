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

    BTree delTree(int val, BTree node) {
        if (node == null) {
            System.out.println("Node not found");
            return node;
        }
        if (val < node.data) {
            node.left = delTree(val, node.left);
        } else if (val > node.data) {
            node.right = delTree(val, node.right);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                BTree currentNode = node.right;
                while (currentNode.left != null) {
                    currentNode = currentNode.left;
                }
                node.data = currentNode.data;
                node.right = delTree(currentNode.data, node.right);
            }
        }
        return balanceTree(val, node);
    }

    int getBalance(BTree node){
        if (node == null) {
            return 0;
        }
        int leftHeight = node.left == null ? 0 : node.left.height;
        int rightHeight = node.right == null ? 0 : node.right.height;
        return leftHeight - rightHeight;
    }

    
    BTree balanceTree(int val, BTree node) {
        int balance = getBalance(node);

        if (balance > 1 && node.left.data > val) {
            node = rightRotate(node);
        } else if (balance > 1 && node.left.data < val) {
            node.left = leftRotate(node.left);
            node = rightRotate(node);
        } else if (balance < -1 && node.right.data < val) {
            node = leftRotate(node);
        } else if (balance < -1 && node.right.data > val) {
            node.right = rightRotate(node.right);
            node = leftRotate(node);
        }
        return node;
    }

    BTree insertData(int val, BTree node) {
        if (node == null) {
            BTree newNode = new BTree(val);
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
            return balanceTree(val, node);
        }
    }

    static void updateHeight(BTree node) {
        int leftNodeHeight = node.left == null ? 0 : node.left.height;
        int rightNodeHeight = node.right == null ? 0 : node.right.height;
        node.height = (leftNodeHeight > rightNodeHeight ? leftNodeHeight : rightNodeHeight) + 1;
    }

    BTree leftRotate(BTree node) {
        BTree newRoot = node.right;
        if (newRoot == null) {
            return node;
        }
        BTree rightNode = newRoot.left;
        newRoot.left = node;
        node.right = rightNode;
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    BTree rightRotate(BTree node) {
        BTree newRoot = node.left;
        if (newRoot == null) {
            return node;
        }
        BTree leftNode = newRoot.right;
        newRoot.right = node;
        node.left = leftNode;
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    public static void main(String[] args) {
        AVL B1 = new AVL();

        int userInput;
        Scanner textFeild = new Scanner(System.in);
        do {
            System.out.println("---------------Binary Tree----------------");
            System.out.println("1 -> Insert Data");
            System.out.println("2 -> Show Inorder");
            System.out.println("3 -> Show Preorder");
            System.out.println("4 -> Show Postorder");
            System.out.println("5 -> Delete");
            System.out.println("6 -> Exit");
            System.out.print("Enter Your Option : ");

            userInput = textFeild.nextInt();

            switch (userInput) {
                case 1:
                    System.out.print("Enter the insert value : ");
                    int insertValue = textFeild.nextInt();
                    root = B1.insertData(insertValue, root);
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
                    System.out.print("Enter the delete value : ");
                    int deleteValue = textFeild.nextInt();
                    root = B1.delTree(deleteValue, root);
                    break;
                case 6:
                    System.out.print("Program Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (userInput != 7);
    }

}
