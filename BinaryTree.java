import java.util.Scanner;

public class BinaryTree {

    Node root;

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }

        public void displayData() {
            System.out.print(value + " ");
        }
    }

    public void insert(int value) {
        root = insertNode(root, value);
    }

    public Node insertNode(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insertNode(node.left, value);
        } else if (value > node.value) {
            node.right = insertNode(node.right, value);
        }
        return node;
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            node.displayData();
            inOrder(node.right);
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            node.displayData();
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            node.displayData();
        }
    }

    
    public static void main(String[] args) {
        BinaryTree bst = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        do{
            System.out.println("Choose an option:");
            System.out.println("1. Insert element");
            System.out.println("2. Inorder traversal");
            System.out.println("3. Preorder traversal");
            System.out.println("4. Postorder traversal");
            System.out.println("5. Exit");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the element to insert:");
                    int value = scanner.nextInt();
                    bst.insert(value);
                    break;
                case 2:
                    System.out.println("Inorder traversal of binary tree:");
                    bst.inOrder(bst.root);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Preorder traversal of binary tree:");
                    bst.preOrder(bst.root);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Postorder traversal of binary tree:");
                    bst.postOrder(bst.root);
                    System.out.println();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }while (!exit);
        scanner.close();
    }
}

