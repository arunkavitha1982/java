import java.util.Scanner;

public class LinkedList {
    Node head;

    class Node {
        String value;
        Node address;

        Node(String value) {
            this.value = value;
            this.address = null;
        }
    }

    public void insert(String data) {
        Node currNode = new Node(data);
        if (head == null) {
            head = currNode;
        }        
        else {
            Node iterNode = head;
            while (iterNode.address != null) {
                iterNode = iterNode.address;
            }
            iterNode.address = currNode;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value +" "+ temp.address + "\n");
                temp = temp.address;
            }
        }
    }

    public void deleteLastValue() {
        if (head == null) {
            System.out.println("List is empty. So deletion is not possible");
        } else {
            Node iterNode = head;
            if (iterNode.address == null) {
                head = null;
            } else {
                while (iterNode.address.address != null) {
                    iterNode = iterNode.address;
                }
                iterNode.address = null;
            }
        }
    }

    public void update(int position, String newValue) {
        if (head == null) {
            System.out.println("List is empty. Update not possible.");
        } else {
            Node temp = head;
            int count = 0;
            while (temp != null) {
                if (count == position) {
                    temp.value = newValue;
                    break;
                }
                else{
                    count++;
                    temp = temp.address;
                }                
            }
            if (temp == null) {
                System.out.println("Position out of bounds. Update not possible.");
            }
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Insert the value");
            System.out.println("2. Delete last value");
            System.out.println("3. Display");
            System.out.println("4. Update");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter value to insert at the end:");
                    String valueEnd = scanner.nextLine();
                    list.insert(valueEnd);
                    break;
                case 2:
                    list.deleteLastValue();
                    break;
                case 3:
                    list.display();
                    break;
                case 4:
                    System.out.println("Enter position to update:");
                    int updatePosition = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.println("Enter new value:");
                    String newValue = scanner.nextLine();
                    list.update(updatePosition, newValue);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
            System.out.println("--------");
        }
        scanner.close();
    }
}
