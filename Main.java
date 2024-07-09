public class Main {
    
   
  public static void main(String[] args) {
     parent p = new parent(10,20,30);
     child c = new child(100, 300, 400);
     System.out.println(p.i);
     p.printJ();
     p.printK(1,2);
     p.printK(1,2,3);
     p.printK(1.1,2.3);
     

     c.printK();

     c.override();

     p.override();
     
  }
}