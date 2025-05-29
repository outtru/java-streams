import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class StreamsUseCases {
    public static void main(String[] args) {
        List<Integer> even  = Stream.of(1,2,3,4,5,6).filter(x->x%2==0).toList();
        System.out.println(even);

        // infinite stream
        AtomicInteger x= new AtomicInteger();
        Stream<AtomicInteger> generate = Stream.generate(()-> new AtomicInteger(x.getAndIncrement()));
        System.out.println(generate.limit(10).toList());
        System.out.println(Stream.iterate(1, s->s+2).limit(10).toList());

    }
}
