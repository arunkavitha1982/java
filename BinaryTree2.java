import java.util.Scanner;

public class BinaryTree2 {

    class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
        }
    }

    static Node root;
    static Node ex;

    // Node add(int val) {
	// 	Node newNode = new Node(val);
	// 	if (root==null) {
	// 		root=newNode;
	// 		System.out.println("successfully root was created");
	// 	} else if(root.data==val) {
	// 		System.out.println("The root value already exists");
	// 	}
	// 	else
	// 	{
	// 		Node curr = root;
	// 		while(val<curr.data || val>curr.data)
	// 		{
	// 			if (val < curr.data)
	// 			{
	// 				if (curr.left == null)
	// 				{
	// 					curr.left = newNode;
	// 					System.out.println("the value of added in left");
	// 					break;
	// 				} else
	// 				{
	// 					curr = curr.left;
	// 				}

	// 			}
	// 			else
	// 			{
	// 				if (curr.right == null)
	// 				{
	// 					curr.right = newNode;
	// 					System.out.println("the value of added in right");
	// 					break;
	// 				} else {
	// 					curr = curr.right;
	// 				}

	// 			}
	// 		}
	// 	}
    //     return newNode;
	// }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    } 

    public void insert(int val) {
        root = add(root, val);
    }

    Node add(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.data){
            root.left = add(root.left, val);
        }
        else if (val > root.data){
            root.right = add(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree2 binatyTree = new BinaryTree2();

        int choice = 0;
        while (choice != 6) {
            System.out.println("1. Insert Data");
            System.out.println("2. InOrder Traversal");
            System.out.println("3. PreOrder Traversal");
            System.out.println("4. PostOrder Traversal");
            System.out.println("5. Delete Node");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to be added: ");
                    int value = scanner.nextInt();
                    binatyTree.insert(value);
                    break;
                case 2:
                    if (root == null) {
                        System.out.println("Tree is empty");
                    } else {
                        binatyTree.inOrder(root);
                    }
                    break;
                case 3:
                    if (root == null) {
                        System.out.println("Tree is empty");
                    } else {
                        // bintree.preOrder(root);
                    }
                    break;
                case 4:
                    if (root == null) {
                        System.out.println("Tree is empty");
                    } else {
                        // bintree.postOrder(root);
                    }
                    break;
                case 5:
                    if (root == null) {
                        System.out.println("Tree is empty");
                    } else {
                        System.out.print("Enter the value to be deleted: ");
                        // int deleteVal = scanner.nextInt();
                        // bintree.delete(root, deleteVal);
                    }
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
}
