public class parent {
    public int i;
    private int j;
    protected int k;

    void printJ(){
        System.out.println(j);
    }
    void printK(){
        System.out.println(k);
    }

    void printK(int a,int b){
        System.out.println(a+b);
    }
    void printK(int a,int b,int c){
        System.out.println(a+b+c);
    }
    void printK(double a,double b){
        System.out.println(a+b);
    }

    void override(){
        System.out.println("parent class");
    }

    parent(int a,int b,int c){
        this.i = a;
        this.j = b;
        this.k = c;
    }
    parent(int a, int c){
        this.i = a;
        this.k = c;
    }
}