import java.util.Scanner;

class LinkedList {
    public Node head;

    public LinkedList() {
        this.head = null;
    }

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null || data <= head.data) {
            if (head != null && head.data == data) {
                System.out.println("This data is already exist");
                return;
            }
            newNode.next = head;
            head = newNode;
            System.out.println("Your data added successfully");
            return;
        }
        Node current = head;
        while (current.next != null && data > current.next.data) {
            if (current.next.data == data) {
                System.out.println("This data is already exist");
                return;
            }
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Your data added successfully");
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.data +" "+ temp.next);
                temp = temp.next;
            }
            // System.out.println("null");
        }
    }

    public void update(int oldData, int newData) {
        Node current = head;
        while (current != null && current.data != oldData) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Data to update not found");
        } else {
            current.data = newData;
            System.out.println("Data updated successfully");
        }
    }

    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == data) {
            head = head.next;
            System.out.println("Data " + data + " deleted");
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Data " + data + " deleted");
        } else {
            System.out.println("Data " + data + " not found");
        }
    }

    public void getMax() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        int max = head.data;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        System.out.println("Maximum value in the list: " + max);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        boolean entry = true;

        while (entry) {
            System.out.println("-----------------------");
            System.out.println("1. Add data");
            System.out.println("2. Display list");
            System.out.println("3. Get maximum value");
            System.out.println("4. Delete data");
            System.out.println("5. Update data");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    System.out.println("Enter data to add:");
                    int dataToAdd = scanner.nextInt();
                    list.add(dataToAdd);
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    list.getMax();
                    break;
                case 4:
                    if (list.head == null) {
                        System.out.println("List is empty");
                    } else {
                        System.out.println("Enter data to delete:");
                        int dataToDelete = scanner.nextInt();
                        list.delete(dataToDelete);
                    }
                    break;
                case 5:
                    System.out.println("Enter data to update:");
                    int oldData = scanner.nextInt();
                    System.out.println("Enter new data:");
                    int newData = scanner.nextInt();
                    list.update(oldData, newData);
                    break;
                case 6:
                    entry = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        System.out.println("You exited");
    }
}