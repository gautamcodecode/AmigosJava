public class InclPractice {
    public static void main(String[] args) {
        Outer ob=new Outer();
        ob.meth1();
        Outer.Inner1 inner = ob.new Inner1();
        inner.meth3();
        Outer.Inner inn =new Outer.Inner();
        inn.meth1();


    }



}
class Outer{
    public void meth1(){
        System.out.println("this is outer class mehthod");
      class Localinnerclass{
          public  void  mathlocal(){
              System.out.println("this is local inner class define in method");
          }
      }
      Localinnerclass lc=new Localinnerclass();
      lc.mathlocal();

    }
    public static class Inner{
        public void meth1(){
            System.out.println("this is inner static class method");
        }
    }
    public  class Inner1{
        public void meth3(){
            System.out.println("this is public innner mathod");
        }

    }
}
