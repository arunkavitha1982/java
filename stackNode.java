import java.util.Scanner;

public class stackNode {
    int value;
    Node next;

    stackNode(int data) {
        this.value = data;
    }

    static Node head;

    static void push(int data) {
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
        System.out.println(head.data);
    }

    static void pop() {
        if (head == null) {
            System.out.println("stack is empty");
            return;
        }
        if (head.next == null) {
            System.out.println("The value as been is removed " + head.data);
            head = null;
            return;
        }
        System.out.println("The value as been is removed " + head.data);
        head = head.next;
    }

    static void peek() {
        if (head == null) {
            System.out.println("stack is empty");
            return;
        }
        System.out.println("The top value is " + head.data);
    }

    static void isEmpty() {
        if (head == null) {
            System.out.println("stack is empty");
        } else {
            System.out.println("stack is not empty");
        }
    }

    static void isFull(int size, int count) {
        if (size == count) {
            System.out.println("the stack is full");
        } else {
            System.out.println("the stack is not full");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice, value, count = 0, size;
        boolean exit = true;
        System.out.print("\nEnter the size of stack : ");
        size = scanner.nextInt();

        do {
            System.out.println("\nStack Operations Menu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Empty");
            System.out.println("5. full");
            System.out.println("6. Exit");
            System.out.print("Enter your choice : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if (count < size) {
                        System.out.print("Enter value to push : ");
                        value = scanner.nextInt();
                        count++;
                        push(value);
                    } else {
                        System.out.println("stack is Full");
                    }

                    break;
                case 2:
                    if (count <= size) {
                        count--;
                        pop();
                    } else {
                        System.out.println("stack is Empty");
                    }
                    break;
                case 3:
                    peek();
                    break;
                case 4:
                    isEmpty();
                    break;
                case 5:
                    isFull(size, count);
                    break;
                case 6:
                    exit = false;
                    System.out.println("Exiting program.");
                    scanner.close();
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (exit);
    }

}