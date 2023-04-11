public class Optional {

    public static void main(String[] args) {
       String s="gautam";
//        java.util.Optional<String> op= java.util.Optional.of(s);
//        System.out.println(op.get());
        java.util.Optional<String> op1= java.util.Optional.ofNullable(s);
        op1.ifPresentOrElse((s1 -> System.out.println(s)),()-> System.out.println("bjhgjb"));

    }
}
