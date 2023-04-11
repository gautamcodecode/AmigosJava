import jdk.dynalink.beans.StaticClass;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people= List.of(
          new Person("john", Gender.MALE),
           new Person("maxi",Gender.MALE),
           new Person("arina",Gender.FEMALE),
           new Person("nani",Gender.FEMALE),
           new Person("tony",Gender.MALE),
           new Person("alice",Gender.FEMALE)
        );
        List<Person> female= new ArrayList<>();
        for(Person p:people){
            if(Gender.FEMALE.equals(p.gender)){
                female.add(p);
            }
        }
        for(Person p:female){
            System.out.println(p);
        }
        System.out.println("Declarative approach");
//        Predicate<Person> personPredicate = p -> Gender.FEMALE.equals(p.gender);
        people.stream().
                filter(p -> Gender.FEMALE.equals(p.gender)).
                collect(Collectors.toList()).
                forEach(System.out::println);
        people.stream().
                filter(p -> Gender.FEMALE.equals(p.gender)).
                forEach(System.out::println);
        List<Person> female1=people.stream().
                filter(p -> Gender.FEMALE.equals(p.gender)).
                collect(Collectors.toList());
        female1.forEach(System.out::println);
        for(Person p:female1){
            System.out.println(p);
        }

    }


    static class Person{
        String name;
        final Gender gender;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }
    }
    public enum Gender {
        MALE, FEMALE
    }
}
