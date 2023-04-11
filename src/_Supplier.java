import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDbconnectionUrl.get());
        System.out.println(getDbconnectionUrlList.get());

    }
    static Supplier<String> getDbconnectionUrl=()->"jdbc://localhost:5432/users";
    static Supplier<List<String>> getDbconnectionUrlList=()->List.of("jdbc://localhost:5432/users","jdbc://localhost:5432/login");
}
