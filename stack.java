import java.util.Scanner;
import java.util.Stack;

public class stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int choice, value;
        boolean exit = true;

        do {
            System.out.println("\nStack Operations Menu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display Stack");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    value = scanner.nextInt();
                    stack.push(value);
                    System.out.println("Pushed " + value + " onto the stack.");
                    break;
                case 2:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty. Cannot pop.");
                    } else {
                        value = stack.pop();
                        System.out.println("Popped " + value + " from the stack.");
                    }
                    break;
                case 3:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        value = stack.peek();
                        System.out.println("Top element is " + value);
                    }
                    break;
                case 4:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack elements: " + stack);
                    }
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    exit = false;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }while(exit);
    }
}
