import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public class Customer1 {
    private final String Name;
    private final String Email;
    private final String phoneNumber;
    private final LocalDate dob;

    public Customer1(String name, String email, String phoneNumber, LocalDate dob) {
        Name = name;
        Email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "Customer1{" +
                "Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dob=" + dob +
                '}';
    }
}
class CustomerValidator{
    public static void main(String[] args) {
            Customer1 customer1=new Customer1("John","jhgjhgj@gmail.com","+919998889998",LocalDate.of(2000, 1 ,31));
        ValidationResult result = CustomerRegistrationValidation
                                            .isMailValid()
                                            .and(CustomerRegistrationValidation.isPhoneNumberValid())
                                            .and(CustomerRegistrationValidation.isAnAdult()).apply(customer1);
        System.out.println(result);
        if (result!=ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }

    }
}
interface CustomerRegistrationValidation extends Function<Customer1,ValidationResult>{
    static CustomerRegistrationValidation isMailValid(){
          return customer->customer.getEmail().contains("@")?ValidationResult.SUCCESS:ValidationResult.EMAIL_NOT_VALID;
    }
    static CustomerRegistrationValidation isPhoneNumberValid(){
          return customer->customer.getPhoneNumber().startsWith("+91")?ValidationResult.SUCCESS:ValidationResult.PHONE_NUMBER_NOT_VALID;
    }
    static CustomerRegistrationValidation isAnAdult(){
          return customer-> Period.between(customer.getDob(),LocalDate.now()).getYears()>16 ?ValidationResult.SUCCESS:ValidationResult.IS_NOT_AN_ADULT;
    }
    default CustomerRegistrationValidation and(CustomerRegistrationValidation other){
        return customer->{
            ValidationResult result = this.apply(customer);
            ValidationResult validationResult = result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
            return validationResult;
        };
    }

}
enum ValidationResult {
    SUCCESS,
    EMAIL_NOT_VALID,
    PHONE_NUMBER_NOT_VALID,
    IS_NOT_AN_ADULT,
}

