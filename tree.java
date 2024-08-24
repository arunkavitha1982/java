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

    // public void add(int value) {
    //     Node newNode = new Node(value);
        
    //     if (root == null) {
    //         root = newNode;
    //         System.out.println("Value added to the tree successfully!");
    //         return;
    //     }
        
    //     Node traversal = root;
    //     Node parent = null;
        
    //     while (traversal != null) {
    //         parent = traversal;
            
    //         if (value == traversal.data) {
    //             System.out.println("Value already exists");
    //             return;
    //         } else if (value < traversal.data) {
    //             traversal = traversal.left;
    //         } else {
    //             traversal = traversal.right;
    //         }
    //     }
        
    //     if (value < parent.data) {
    //         parent.left = newNode;
    //     } else {
    //         parent.right = newNode;
    //     }
        
    //     System.out.println("Value added to the tree successfully!");
    // }
    Node add(int val) {
		Node newNode = new Node(val);
		if (root==null) {
			root=newNode;
			System.out.println("successfully root was created");
		} else if(root.data==val) {
			System.out.println("The root value already exists");
		}
		else
		{
			Node curr = root;
			while(val<curr.data || val>curr.data)
			{
				if (val < curr.data)
				{
					if (curr.left == null)
					{
						curr.left = newNode;
						System.out.println("the value of added in left");
						break;
					} else
					{
						curr = curr.left;
					}

				}
				else
				{
					if (curr.right == null)
					{
						curr.right = newNode;
						System.out.println("the value of added in right");
						break;
					} else {
						curr = curr.right;
					}

				}
			}
		}
        return newNode;
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
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }

    Node delete(Node root, int val) {
        if (root == null) {
            System.out.println("Value not found in the tree.");
            return null;
        }
    
        if (val < root.data) {
            root.left = delete(root.left, val);
        }
        else if (val > root.data) {
            root.right = delete(root.right, val);
        } 
        else {
            if (root.left == null) {
                return root.right;
            } 
            else if (root.right == null) {
                return root.left;
            } 
            else {
                Node currentNode = root.right;
                while (currentNode.left != null) {
                    currentNode = currentNode.left;
                }
                root.data = currentNode.data;
                root.right = delete(root.right, currentNode.data);
            }
            System.out.println("Value deleted successfully.");
        }
        return root;
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        tree bintree = new tree();

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
                        System.out.print("Enter the value to be deleted: ");
                        int deleteVal = scanner.nextInt();
                        bintree.delete(root, deleteVal);
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
