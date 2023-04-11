import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println(validateYourNumber.test("919998889998"));
        System.out.println(validateYourNumber.test("99998889998"));
        System.out.println(validateYourNumber.and(containNumber3).test("919998889998"));
        System.out.println(validateYourNumber.and(containNumber3).test("919998889993"));
        System.out.println(validateYourNumber.or(containNumber3).test("919998889998"));

    }
    static Predicate<String> validateYourNumber=phoneNumber->phoneNumber.startsWith("91")&&phoneNumber.length()==12;
    static Predicate<String> containNumber3=phoneNumber->phoneNumber.contains("3");
}
