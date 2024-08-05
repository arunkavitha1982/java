import java.util.Scanner;

public class BinaryTree {
    class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    Node root;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bintree = new BinaryTree();

        int choice = 0;
        while (choice != 7) {
            System.out.println("1. Push");
            System.out.println("2. In-order");
            System.out.println("3. Pre-order");
            System.out.println("4. Post-order");
            System.out.println("5. Delete");
            System.out.println("6. Exit\n");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the value to be added: ");
                    int value = scanner.nextInt();
                    bintree.add(value);
                    break;
                case 2:
                    System.out.println("In-order traversal:");
                    bintree.inOrder(bintree.root);
                    break;
                case 3:
                    System.out.println("Pre-order traversal:");
                    bintree.preOrder(bintree.root);
                    break;
                case 4:
                    System.out.println("Post-order traversal:");
                    bintree.postOrder(bintree.root);
                    break;
                case 5:
                    System.out.print("Enter the value to be deleted: ");
                    int deleteVal = scanner.nextInt();
                    bintree.delete(deleteVal);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            System.out.println("Value added to the tree successfully!");
        } else {
            Node parent = null;
            Node current = root;
            while (true) {
                parent = current;
                if (value < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        System.out.println("Value added to the tree successfully!");
                        return;
                    }
                } else if (value > current.data) {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        System.out.println("Value added to the tree successfully!");
                        return;
                    }
                } else {
                    System.out.println("Value already exists.");
                    return;
                }
            }
        }
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data);
            inOrder(root.right);
        }
    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data);
        }
    }

    public void delete(int value) {
        Node parent = null;
        Node current = root;

        while (current != null && current.data != value) {
            parent = current;
            if (value < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) {
            System.out.println("Value not found in the tree.");
            return;
        }
    
        if (current.left == null || current.right == null) {
            Node newCurr;
            if (current.left == null) {
                newCurr = current.right;  
            } else {
                newCurr = current.left;
            }
    
            if (parent == null) {
                root = newCurr;
            } else if (current == parent.left) {
                parent.left = newCurr;
            } else {
                parent.right = newCurr;
            }
        } else {
            Node succParent = current;
            Node succ = current.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }
    
            current.data = succ.data;
    
           
            if (succParent != current) {
                succParent.left = succ.right;
            } else {
                succParent.right = succ.right;
            }
        }
    
        System.out.println("Value deleted successfully");
    }
    

}
