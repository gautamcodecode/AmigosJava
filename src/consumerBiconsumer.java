import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class consumerBiconsumer {
    public static void main(String[] args) {

        Customer customer1= new Customer("Smith",999999999);
        greetCustomer.accept(customer1);
        greetCustomer1.accept(customer1,false);
        greetCustomer1.accept(customer1,true);

    }
    //        Consumer takes argument and return void
    static Consumer<Customer> greetCustomer=customer-> System.out.println("hello "+customer.name+" thanks for register "+customer.number);
    static BiConsumer<Customer, Boolean> greetCustomer1=(customer, ShowPhoneNumber)->
            System.out.println("hello " + customer.name + " thanks for register " + (ShowPhoneNumber ? customer.number : "****"));

    static class Customer{
        String name;
        int number;

        public Customer(String name, int number) {
            this.name = name;
            this.number = number;
        }
    }
}
