public class Practice {
    public static void main(String[] args) {
       prac ob =new prac();
       int c= ob.add();
        System.out.println(c);
        int v = ob.v;
        System.out.println(v);
    }
}
class prac{
    public int add(){
        int a=1;
        int b=2;
        int c=a+b;
        return c;
    }
    int v=add();
   
}