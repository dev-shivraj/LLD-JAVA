package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    streams are used to do multiple data manipulation operations in one go.

    Steps to use Streams :
    1. Create a collection of data : Collection Data Structure
    2. Convert the collection into a stream using the stream() method.
    3. Do the data manipulation operations on the stream using the various methods provided by the Stream API.
    4. Convert the stream back into a collection using the methods provided by the Stream API : collect(), toArray(), forEach(), etc.


    Type of Stream Operations :
        1. Intermediate Operations : These operations are used to do the data manipulation operations on the stream and return a new stream.
                                     These operations are lazy in nature and are not executed until a terminal operation is invoked on the stream.
                                     Examples : filter(), map(), sorted(), distinct(), limit(), skip(), flatMap(), peek(), etc.

        2. Terminal Operations : These operations are used to convert the stream back into a collection or to perform some final operation on the stream.
                                 It closes the stream and returns a non-stream value.
                                 Once a terminal operation is invoked on the stream, the stream can not be used again.
                                 These operations are eager in nature and are executed immediately.
                                 Examples : collect(), findAny(), findFirst(), toArray(), forEach(), reduce(), count(), etc.

 */
public class Client {
    public static void main(String[] args) {
        // find the even numbers in the given list

        // step 1 : create a collection of data
        List<Integer> arr = Arrays.asList(3, 2, 1, 5, 4);

        // step 2 : covert to stream
        Stream<Integer> stream = arr.stream();

        // step 3: do the data manipulation
        stream = stream.filter(x -> x % 2 == 0);

        // step 4: convert back to collection
        List<Integer> evenNumbers = stream.collect(Collectors.toList());

        System.out.println(evenNumbers);




        // one-liner :
        List<Integer> evenNumbers2 = arr.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbers2);

        /*
            once we collect the stream, we can not operate back on that stream. we have to create a new stream from the collection again.
            for example inn above example, if we want to find the odd numbers in the same list, we have to create a new stream from the collection again.
            below will not work and will throw an exception:
                List<Integer> oddNumbers = stream.filter(x -> x % 2 != 0).collect(Collectors.toList());
                System.out.println(oddNumbers);


            we can create a new stream from the collection again to find the odd numbers:
                List<Integer> oddNumbers = arr.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
                System.out.println(oddNumbers);
         */

        // instead of collecting the stream, we can directly print it
        arr.stream()
                .filter(x -> x % 2 == 0)
                .sorted(). // sort the even numbers in ascending order
                forEach(x -> System.out.print(x + " "));

        // we can also use comparator to sort the even numbers in descending order
        System.out.println();
        arr.stream()
                .filter(x -> x % 2 == 0)
                .sorted((a, b) -> b - a) // sort the even numbers in descending order
                .forEach(x -> System.out.print(x + " "));
    }
}
