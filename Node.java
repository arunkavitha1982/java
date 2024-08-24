import java.util.Scanner;

class Node {
    int data;
    Node next;
    public int value;
    public Node left;
    public Node right;

    Node(int data) {
        this.data = data;

    }

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";

    static Node head;

    static void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else if (head.data == data) {
            System.out.println("this data already exists");
            return;
        } else if (head.data > data) {
            newNode.next = head;
            head = newNode;
        } else {
            Node present = head;
            while (present.next != null && present.next.data < data) {
                present = present.next;
            }
            if (present.next != null && present.next.data == data) {
                System.out.println("this data already exists");
                return;
            }
            newNode.next = present.next;
            present.next = newNode;
        }
        System.out.println("Your entered value successfully added ");
    }
    // add end

    // Delete Method

    static void Delete(int uselessData) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == uselessData) {
            head = head.next;
            System.out.println("The entered Value has been successfully delected");
            return;
        } else if (uselessData < head.data) {
            System.err.println("The entered Value not found in the list");
            return;
        } else {
            Node present = head;
            while (present.next != null && present.next.data != uselessData) {
                if (uselessData < present.data) {
                    System.err.println("The entered Value not found in the list");
                    return;
                }
                present = present.next;
            }
            if (present.next != null) {
                present.next = present.next.next;
                System.out.println("The entered Value has been successfully delected");
                return;
            }
            System.err.println("The entered Value not found in the list");

        }
    }

    static public void Update(int oldValue, int newValue) {
        Node newNode = new Node(newValue);
        Node present = head;
        if (newValue < oldValue) {
            // add
            if (present.data == newValue) 
            {
                System.out.println("Updated value already exists");
                return;
            } 
            else if (present.data > newValue) 
            {
                newNode.next = present;
                present = newNode;
                head = present;
            } 
            else 
            {
                while (present.next != null && present.next.data < newValue) 
                {
                    present = present.next;
                }
                if (present.next != null && present.next.data == newValue) 
                {
                    System.out.println("Updated value already exists");
                    return;
                }
                newNode.next = present.next;
                present.next = newNode;
            }

            //delete
            if (oldValue < head.data) 
            {
                
                Delete(newValue);
                System.err.println("The entered old Value not found in the list");
                return;
            } 
            else 
            {
                while (present.next != null && present.next.data != oldValue) 
                {
                    if (oldValue < present.data) 
                    {
                        Delete(newValue);
                        System.err.println("The entered Value not found in the list");
                        return;
                    }
                    present = present.next;
                }
                if (present.next != null) 
                {
                    present.next = present.next.next;
                    System.out.println("The entered Value has been successfully Updated");
                    return;
                }
                else
                {
                    Delete(newValue);
                    System.err.println("The entered Value not found in the list");
                }

        } 
    }

    }

    static void display() {
        if (head == null) {
            System.out.println("list  is empty");
        } else {
            Node temp = head;
            while (temp.next != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println(temp.data);
        }
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        int userChoice;
        do {
            System.out.println(  "\n<----------- LINKED LIST ------------>\n");
            System.out.println("1 --> Add values in list");
            System.out.println("2 --> Delete values in list");
            System.out.println("3 --> Update values in list");
            System.out.println("4 --> Display list");
            System.out.println("5 --> Exit\n");
            System.out.print(BLUE + "Enter Your Choice : "  );
            userChoice = inputScanner.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.print(  "\nEnter your value: " );
                    int data = inputScanner.nextInt();
                    add(data);
                    break;
                case 2:
                    System.out.print(  "\nEnter your delete value");
                    int uselessData = inputScanner.nextInt();
                    Delete(uselessData);
                    break;
                case 3:
                    if (head == null) {
                        System.err.println("List is empty");

                    } else {
                        System.out.print(  "\nEnter the old value ");
                        int oldValue = inputScanner.nextInt();
                        if (head.data > oldValue) {
                            System.out.println("The Entered old value not Found in the list");
                        } else {
                            System.out.print(  "\nEnter the new value "  );
                            int newValue = inputScanner.nextInt();
                            Update(oldValue, newValue);
                        }

                    }
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    System.out.println(  "Exit successfully"  );
                    break;
                default:
                    System.out.println(   "Invalid choice"  );
                    break;
            }
        } while (userChoice != 8);

        inputScanner.close();
    }
}
