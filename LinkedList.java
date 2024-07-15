import java.util.Scanner;

class LinkedList {
    static Node head;

    public static Node insert(int data, Node head) {
        if (contains(data,head)) {
            System.out.println("Duplicate value found: " + data);
            return head;
        }

        Node newNode = new Node(data);

        if (head == null || head.data > data) {
            // newNode.nextAddress = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.nextAddress != null && current.nextAddress.data < data) {
                current = current.nextAddress;
            }
            newNode.nextAddress = current.nextAddress;
            current.nextAddress = newNode;
        }
        System.out.println("Node inserted successfully");
        return head;
    }

    public static boolean contains(int data, Node head) {
        // Node current = head;
        while (head != null) {
            if (head.data == data) {
                return true;
            }
            head = head.nextAddress;
        }
        return false;
    }

    public static void display(Node head) {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.data + " " + temp.nextAddress);
                temp = temp.nextAddress;
            }
        }
    }

    // public void update(int oldValData, int newData) {
    // if (delete(oldValData)) {
    // insert(newData);
    // }
    // else{
    // System.out.println("Data is not fount");
    // }
    // }


   /* public void update(int oldVal, int newVal) {
        Node newNode = new Node(newVal);
        Node curNode = head;

        if (newVal < oldVal) {
            if (curNode.data > newVal) {
                newNode.nextAddress = curNode;
                head = newNode;

                while (curNode.nextAddress != null) {
                    if (curNode.nextAddress.data == oldVal) {
                        curNode.nextAddress = curNode.nextAddress.nextAddress;
                    } else {
                        curNode = curNode.nextAddress;
                    }
                }
            }
            
            else {
                while (curNode.nextAddress != null) {
                    if (curNode.nextAddress.data == oldVal) {
                        curNode.nextAddress = curNode.nextAddress.nextAddress;
                    } else {
                        curNode = curNode.nextAddress;
                    }
                }
                newNode.nextAddress = curNode.nextAddress;
                curNode.nextAddress = newNode;
            }

            // else {
            // System.out.println("else condition");
            // if (curNode.nextAddress.data > newVal) {
            // newNode.nextAddress = curNode.nextAddress;
            // curNode.nextAddress = newNode;
            // while (curNode.nextAddress != null) {
            // if (curNode.nextAddress.data == oldVal) {
            // curNode.nextAddress = curNode.nextAddress.nextAddress;
            // } else {
            // curNode = curNode.nextAddress;
            // }
            // }
            // if(curNode.nextAddress == null){
            // curNode.data = newVal;
            // curNode = curNode.nextAddress;
            // }
            // }
            // else{
            // curNode = curNode.nextAddress;

            // }

            // }
        } else {
            System.out.println("eeeeeeefr3rf");
        }
    }*/ 

    public static Node update(int oldVal, int newVal, Node head){
        Node newNode = new Node(newVal);
        Node current = head;

        if (newVal < oldVal) {
            // Adding new value
            if (head == null || head.data > newVal) {
                head = newNode;
            } else {                
                while (current.nextAddress != null && current.nextAddress.data < newVal) {
                    current = current.nextAddress;
                }
                newNode.nextAddress = current.nextAddress;
                current.nextAddress = newNode;
            }
            //deleteing old value
            return delete(oldVal, current);            
        }
        else{
            // delete the old value
            while (current.nextAddress != null && current.nextAddress.data != oldVal) {
                current = current.nextAddress;
            }
            if (current.nextAddress != null) {
                current.nextAddress = current.nextAddress.nextAddress;
            }
            //the value not exit
            // else {
            //     return head;
            // }
            //Adding new value
            return insert(newVal, current);
        }
    }

    public static Node delete(int data, Node head) {
        if (head.data == data) {
            head = null;
            System.out.println("Data " + data + " deleted");
            return head;
        }

        else if (head.data < data) {
            Node current = head;
            while (current.nextAddress != null && current.nextAddress.data != data) {
                if (data < current.data) {
                    System.out.println("Data " + data + " not found");
                    return head;
                }
                current = current.nextAddress;
            }
            if (current.nextAddress != null) {
                current.nextAddress = current.nextAddress.nextAddress;
                System.out.println("Data " + data + " deleted");
                return head;
            } else {
                System.out.println("Data " + data + " not found");
                return head;
            }
        }
        System.out.println("Data " + data + " not found");
        return head;
    }

    public static void main(String[] args) {

        // LinkedList list = new LinkedList();
        Scanner UserInput = new Scanner(System.in);
        boolean entry = true;

        do {
            System.out.println("-----------------------");
            System.out.println("1. Insert the node");
            System.out.println("2. Display");
            System.out.println("3. delete");
            System.out.println("4. Update");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int userInput = UserInput.nextInt();

            switch (userInput) {
                case 1:
                    System.out.println("Enter data to add:");
                    int dataToAdd = UserInput.nextInt();
                    head = insert(dataToAdd, head);                    
                    break;
                case 2:
                    display(head);
                    break;

                case 3:
                    if (head == null) {
                        System.out.println("List is empty");
                    } else {
                        System.out.println("Enter data to delete:");
                        int dataToDelete = UserInput.nextInt();
                        head = delete(dataToDelete,head);
                    }
                    break;
                case 4:
                    if (head == null) {
                        System.out.println("List is empty");
                    } else {
                        System.out.println("Enter data to update:");
                        int oldValData = UserInput.nextInt();
                        System.out.println("Enter new data:");
                        int newData = UserInput.nextInt();
                        head = update(oldValData, newData,head);
                    }

                    break;
                case 5:
                    entry = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (entry);
        System.out.println("You exited");
    }
}