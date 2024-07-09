public class child extends parent {
    public int m;
    
    child(int a, int c, int d){
         super(a,c);
         m = d;
    }
    @Override 
    void override() {
        System.out.println("child class");
    }
}