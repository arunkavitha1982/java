import java.util.Scanner;

public class AVLTree2 {
    int data, height;
    AVLTree left, right;

    public AVLTree2(int data) {
        this.data = data;
        this.height = 1;
    }
}

class ATree {
    private AVLTree root;

    public ATree() {
        root = null;
    }

    // 1. Insert a value and balance the tree
    public AVLTree insert(int value, AVLTree node) {
        if (node == null) return new AVLTree(value);
        if (value < node.data) node.left = insert(value, node.left);
        else if (value > node.data) node.right = insert(value, node.right);
        else return node; // Value already exists

        updateHeight(node);
        return balance(node, value);
    }

    // 2. Delete a value and balance the tree
    public AVLTree delete(AVLTree node, int value) {
        if (node == null) return null;
        if (value < node.data) node.left = delete(node.left, value);
        else if (value > node.data) node.right = delete(node.right, value);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            AVLTree temp = getMin(node.right);
            node.data = temp.data;
            node.right = delete(node.right, temp.data);
        }

        updateHeight(node);
        return balance(node, value);
    }

    // 3. In-order traversal
    public void inOrder(AVLTree node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println("Node: " + node.data + ", Height: " + node.height);
            inOrder(node.right);
        }
    }

    // 4. Pre-order traversal
    public void preOrder(AVLTree node) {
        if (node != null) {
            System.out.println("Node: " + node.data + ", Height: " + node.height);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 5. Update height of a node
    public void updateHeight(AVLTree node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    // 6. Get the balance factor of a node
    public int getBalance(AVLTree node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    // 7. Get height of a node
    public int height(AVLTree node) {
        return (node == null) ? 0 : node.height;
    }

    // 8. Left rotation
    public AVLTree leftRotate(AVLTree node) {
        AVLTree newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    // 9. Right rotation
    public AVLTree rightRotate(AVLTree node) {
        AVLTree newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    // 10. Get minimum value node
    public AVLTree getMin(AVLTree node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // Insert method for root
    public void insertData(int value) {
        root = insert(value, root);
    }

    // Delete method for root
    public void deleteData(int value) {
        root = delete(root, value);
    }

    // Show In-order traversal
    public void showInOrder() {
        inOrder(root);
    }

    // Show Pre-order traversal
    public void showPreOrder() {
        preOrder(root);
    }

    // Balance the tree during insert and delete
    private AVLTree balance(AVLTree node, int value) {
        int balance = getBalance(node);
        if (balance > 1 && value < node.left.data) return rightRotate(node);  // Left-Left
        if (balance > 1 && value > node.left.data) {  // Left-Right
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && value > node.right.data) return leftRotate(node);  // Right-Right
        if (balance < -1 && value < node.right.data) {  // Right-Left
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public static void main(String[] args) {
        ATree tree = new ATree();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1 -> Insert Data");
            System.out.println("2 -> Show Inorder");
            System.out.println("3 -> Show Preorder");
            System.out.println("4 -> Delete Data");
            System.out.println("5 -> Exit");
            System.out.print("Enter Your Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    tree.insertData(value);
                    break;
                case 2:
                    tree.showInOrder();
                    break;
                case 3:
                    tree.showPreOrder();
                    break;
                case 4:
                    System.out.print("Enter value to delete: ");
                    int delValue = scanner.nextInt();
                    tree.deleteData(delValue);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

