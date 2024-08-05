import java.util.Scanner;

public class tree {
    class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
        }
    }

    static Node root;
    Node traversal;

    public void add(int value) {

        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            System.out.println("value added to the tree succesfully!");
        } else if (value == root.data) {
            System.out.println("value alredy exist");
        } else {
            traversal = root;

            while (value > traversal.data) {

                if (traversal.right == null) {
                    traversal.right = newNode;
                    System.out.println("value added to the tree succesfully!");
                    break;
                } else {
                    traversal = traversal.right;
                    if (value == traversal.data) {
                        System.out.println("value already exist");
                        break;
                    }
                }
            }

            while (value < traversal.data) {
                if (value == traversal.data) {
                    System.out.println("value already exist");
                } else if (traversal.left == null) {
                    traversal.left = newNode;
                    System.out.println("value added to the tree succesfully!");
                    break;
                } else {
                    traversal = traversal.left;
                    if (value == traversal.data) {
                        System.out.println("value already exist");
                        break;
                    }
                }
            }

        }
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }

    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.data);
            inOrder(root.left);
            inOrder(root.right);
        }

    }

    public void postOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            inOrder(root.right);
            System.out.println(root.data);
        }

    }

    public void delete(int deleteVal) {
        Node current = root;
        Node previous = null;
        while (current != null && current.data != deleteVal) {
            previous = current;
            if (deleteVal < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) {
            System.out.println("Value not found in the tree.");
        }

        else if (current.left == null && current.right == null) {
            if (previous == null) {
                root = null;
            } else if (previous.left == current) {
                previous.left = null;
            } else {
                previous.right = null;
            }
            System.out.println("Value deleted successfully");
        }

        else if (current.left == null || current.right == null) {
            Node child;
            if (current.left != null) {
                child = current.left;
            } else {
                child = current.right;
            }

            if (previous == null) {
                root = child;
            } else if (previous.left == current) {
                previous.left = child;
            } else {
                previous.right = child;
            }
            System.out.println("Value deleted successfully");
        }

        else {
            Node node1 = current;
            Node node2 = current.right;
            while (node2.left != null) {
                node1 = node2;
                node2 = node2.left;
            }
            current.data = node2.data;
            if (node1 != current) {
                node1.left = node2.right;
            } else {
                node1.right = node2.right;
            }
            System.out.println("Value deleted successfully");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        tree bintree = new tree();

        int choice = 0;
        while (choice != 6) {
            System.out.println("1. Push");
            System.out.println("2. inOrder ");
            System.out.println("3. preOrder ");
            System.out.println("4. postOrder ");
            System.out.println("5. delete ");
            System.out.println("6. exit ");
            System.out.print("enter your choice : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the value to be added : ");
                    int value = scanner.nextInt();
                    bintree.add(value);
                    break;
                case 2:
                    if (root == null) {
                        System.out.println("Tree is empty");
                    } else {
                        bintree.inOrder(root);
                    }
                    break;
                case 3:
                    if (root == null) {
                        System.out.println("Tree is empty");
                    } else {
                        bintree.preOrder(root);

                    }
                    break;
                case 4:
                    if (root == null) {
                        System.out.println("Tree is empty");
                    } else {
                        bintree.postOrder(root);

                    }
                    break;
                case 5:
                    if (root == null) {
                        System.out.println("Tree is empty");
                    } else {
                        System.out.print("Enter the value to be deleted : ");
                        int deleteVal = scanner.nextInt();
                        bintree.delete(deleteVal);
                    }

                    break;
                case 6:
                    System.out.print("exiting.....");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

}
