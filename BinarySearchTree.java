import java.util.Scanner;

public class BinarySearchTree {
    class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int item) {
            value = item;
            left = right = null;
        }
    }

    static TreeNode root;

    TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.value) {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        } else {
            System.out.println("The root value already exists");
        }
        return root;
    }

    void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }

    void dfs(TreeNode root) {
        if (root != null) {
            System.out.println(root.value);
            dfs(root.left);
            dfs(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        int choice = 0;

        do {
            System.out.println("1. Insert a value");
            System.out.println("2. InOrder Traversal");
            System.out.println("3. DFS Traversal");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    root = bst.insert(root, value);
                    System.out.println("insert value.");
                    break;

                case 2:
                    System.out.println("in-order traversal of the BST:");
                    bst.inorder(root);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("DFS traversal of the BST:");
                    bst.dfs(root);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("exiting.");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 4);
        scanner.close();
    }
}
