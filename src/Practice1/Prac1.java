package Practice1;

public class Prac1 {
    public static void main(String[] args) {
        A o=new A();
        o.meth1();
        o.meth1();
        o.meth1();
    }
}
class  A{
    int a=5;
    public  void  meth1(){
        int b=5;
        System.out.println(+a+" "+b);
        ++a;
        ++b;
    }
}