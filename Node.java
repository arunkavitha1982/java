public class Node {
    int Value;
    Node Adderss;

    Node(int Num)
    {
        this.Value = Num;
        this.Adderss = null; 
    }
    

    void Print(Node Odj) {
        Node Node = Odj;
        while(Node != null) {
            System.out.println(Node.Value);
            System.out.println(Node.Adderss);
            Node = Node.Adderss;
        }
    }


    public static void main(String args[]){  
        Node First = new Node(1);
        Node Second = new Node(2);
        Node Third = new Node(3);
        Node Fourth = new Node(4);

        First.Adderss = Second;
        Second.Adderss = Third;
        Third.Adderss = Fourth;
        Fourth.Adderss = null;

        System.out.println();
        System.out.println(First);
        System.out.println();        
    }    
}