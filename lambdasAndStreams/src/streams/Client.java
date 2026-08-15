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
 */
public class Client {
    public static void main(String[] args) {
        // find the even numbers in the given list

        // step 1 : create a collection of data
        List<Integer> arr = Arrays.asList(3, 2, 1, 5, 4);

        // step 2 : covert to stream
        Stream<Integer> stream = arr.stream();

        // step 3: do the data manupulation
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
    }
}
