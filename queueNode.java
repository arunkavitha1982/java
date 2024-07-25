import java.util.Scanner;

public class queueNode {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;
    static Node current;

    static void equeue(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            current = newNode;
        } else {
            current.next = newNode;
            current = newNode;
        }
    }

    static void Dequeue() {
        if (head == null) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("The value as been is removed" + head.data);
        head = head.next;

        if (head == null) {
            current = null;
        }
    }

    static void peek() {
        if (head == null) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("The top value is " + head.data);
    }

    static void isEmpty() {
        if (head == null) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue is not empty");
        }
    }

    static void isFull(int size, int count) {
        if (size == count) {
            System.out.println("The queue is full");
        } else {
            System.out.println("The queue is not full");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice, value, count = 0, size;
        boolean exit = true;

        System.out.print("Enter the size of queue: ");
        size = scanner.nextInt();

        do {
            System.out.println("\nQueue Operations Menu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Check if Empty");
            System.out.println("5. Check if Full");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (count < size) {
                        System.out.print("Enter value to enqueue: ");
                        value = scanner.nextInt();
                        count++;
                        equeue(value);
                    } else {
                        System.out.println("Queue is full");
                    }
                    break;
                case 2:
                    if (count > 0) {
                        count--;
                        Dequeue();
                    } else {
                        System.out.println("Queue is empty");
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
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (exit);
    }
}
