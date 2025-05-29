import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8Streams {
    public static void main(String[] args) {

        // Predicate - (Functional interface) return Boolena value
        Predicate<Integer> isEven = x->x%2==0;
        System.out.println(isEven.test(10));
        System.out.println(isEven.negate().test(10));
        Predicate<Integer> isGreaterThanAndEqual10 = x->x>=10;
        System.out.println(isGreaterThanAndEqual10.and(isEven).test(9));


        // Function -> works and return;
        Function<Integer, Integer> addTen = x->x+10;
        Function<Integer, String> addTenString = x->x+" ten";
        System.out.println(addTen.andThen(addTenString).apply(5));
        Function<Integer, Integer> addTwo = x->x+2;
        System.out.println(addTen.compose(addTwo).apply(12));
        System.out.println(Function.identity().apply(10));

        // Consumer accepts, but return nothing
        Consumer<Integer> consumer = x-> System.out.println(x+" consumer");
        consumer.accept(10);
        System.out.println("===========================");
        Consumer<List<Integer>> printAll = x-> x.forEach(System.out::println);
        printAll.accept(List.of(10,20));
        System.out.println("===========================");


        // Supplier
        Supplier<String> dbConnectionString = ()->"127.0.0.0//exampleConnection";
        System.out.println(dbConnectionString.get());
    }
}
