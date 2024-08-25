import java.util.*;

public class Add {
    class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int item) {
            value = item;
            left = right = null;
        }
    }

    TreeNode root;

    void insert(int value) {
        TreeNode newNode = new TreeNode(value);
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            root = newNode;
            return;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();
            if (currentNode.left == null) {
                currentNode.left = newNode;
                return;
            }
            queue.add(currentNode.left);

            if (currentNode.right == null) {
                currentNode.right = newNode;
                return;
            }
            queue.add(currentNode.right);

        }
    }

    void dfs(TreeNode root) {
        if (root != null) {
            System.out.println(root.value);
            dfs(root.left);
            dfs(root.right);
        }
    }

    void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }

    void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();
            System.out.print(currentNode.value + " ");
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Add bst = new Add();
        int choice = 0;

        do {
            System.out.println("1. Insert a value");
            System.out.println("2. In-order Traversal");
            System.out.println("3. DFS Traversal");
            System.out.println("4. BFS Traversal");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    bst.insert(value);
                    System.out.println("Value inserted.");
                    break;

                case 2:
                    if (bst.root == null) {
                        System.out.println("The tree is Empty");
                        return;
                    }
                    bst.inorder(bst.root);
                    System.out.println();
                    break;
                case 3:
                    if (bst.root == null) {
                        System.out.println("The tree is Empty");
                        return;
                    }
                    bst.dfs(bst.root);
                    System.out.println();
                    break;
                case 4:
                    if (bst.root == null) {
                        System.out.println("The tree is Empty");
                        return;
                    }
                    bst.bfs(bst.root);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Exiting.");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 5);
        scanner.close();
    }
}
