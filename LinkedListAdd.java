import java.util.Scanner;

public class LinkedListAdd {
    Node head;

    class Node {
        int value;
        Node address;

        Node(int value) {
            this.value = value;
            this.address = null;
        }
    }

    public void update(int position, int newValue) {
        if (contains(newValue)) {
            System.out.println("Duplicate value found: " + newValue);
            return;
        }
        if (head == null) {
            System.out.println("List is empty. Update not possible.");
        } else {
            Node temp = head;
            int count = 0;
            while (temp != null) {
                if (count == position) {
                    temp.value = newValue;
                    break;
                } else {
                    count++;
                    temp = temp.address;
                }
            }
            if (temp == null) {
                System.out.println("Position out of bounds. Update not possible.");
            }
        }
    }

    public void insert(int data) {
        if (contains(data)) {
            System.out.println("Duplicate value found: " + data);
            return;
        }

        Node newNode = new Node(data);

        if (head == null || head.value > data) {
            newNode.address = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.address != null && current.address.value < data) {
                current = current.address;
            }
            newNode.address = current.address;
            current.address = newNode;
        }
        System.out.println("Node inserted successfully");
    }

    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.value == data) {
                return true;
            }
            current = current.address;
        }
        return false;
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

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            System.out.println("-----------------------");

            while (temp != null) {
                System.out.println(temp.value + " " + (temp.address != null ? temp.address.value : "null"));
                temp = temp.address;
            }
        }
    }

    public static void main(String[] args) {
        LinkedListAdd list = new LinkedListAdd();
        Scanner UserInput = new Scanner(System.in);
        boolean exit = false;

        do {
            System.out.println("Choose an option:");
            System.out.println("1. Insert the node");
            System.out.println("2. Display");
            System.out.println("3. Update");
            System.out.println("4. delete");
            System.out.println("5. Exit");
            int choice = UserInput.nextInt();
            UserInput.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter value to insert:");
                    int value = UserInput.nextInt();
                    list.insert(value);
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    System.out.println("Enter position to update:");
                    int updatePosition = UserInput.nextInt();
                    System.out.println("Enter new value:");
                    int newValue = UserInput.nextInt();
                    list.update(updatePosition, newValue);
                    break;
                case 4:
                    list.deleteLastValue();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }

            System.out.println();
            System.out.println("--------");
        } while (!exit);

        UserInput.close();
    }
}
