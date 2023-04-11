import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionBifunction {
    public static void main(String[] args) {
        int increament=firstAdd.apply(1);
        System.out.println(increament);
        int multiply=ThenMultiply.apply(10);
        System.out.println(multiply);
        Function<Integer,Integer> firstAddThenMultiply=firstAdd.andThen(ThenMultiply);
        int hybrid=firstAddThenMultiply.apply(1);
        System.out.println(hybrid);
        int biFunctionResult=increamentByOneAndThenMultiplyByBifunction.apply(1,10);
        System.out.println(biFunctionResult);
    }
    static Function<Integer,Integer> firstAdd= a->a+2;
    static Function<Integer,Integer> ThenMultiply=b->b*10;
    static BiFunction<Integer,Integer,Integer> increamentByOneAndThenMultiplyByBifunction=(a, b)->(a+2)*b;
}
