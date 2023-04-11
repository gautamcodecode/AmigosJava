public class Anno_inner_class {
    public static void main(String[] args) {
        Outer1 ob=new Outer1();
        Outer1.Inter ob1= () -> System.out.println("this is anno inner class");
//        Outer1.Inter ob1= new Outer1.Inter() {
//            @Override
//            public void meth2() {
//                System.out.println("this is anno inner class");
//
//            }
//        };
        ob.meth1();
        ob1.meth2();

    }
}

class Outer1{
    public void meth1(){
        System.out.println("outer 1 method");
    }
    interface Inter{
        public void meth2();
    }

}
class Outer2 implements  Outer1.Inter {

    @Override
    public void meth2() {

    }
}