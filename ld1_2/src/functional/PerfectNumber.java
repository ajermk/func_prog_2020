package functional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerfectNumber {

    public enum STATE
    {
        DEFICIENT,
        ABUNDANT,
        PERFECT

    }
    public static STATE process(int n)
    {
        Set<Integer> divisorSet = divisors(n);
        int divisorSum = divisorSet // take divisor set
                            .stream() // have to use stream() instead of instream
                            .mapToInt(Integer::intValue) // so convert to int
                            .sum(); // get sum of divisors

        // nested ternary operator instead of bunch of ifs/else bc why not
        return divisorSum == n ? STATE.PERFECT
                               : (divisorSum > n ? STATE.ABUNDANT
                                                  : STATE.DEFICIENT);
    }

    public static Set<Integer> divisors(int n)
    {
        Set<Integer> divisorSet = IntStream
                .range(1,n) // for loop, excluding n
                .filter(i -> n % i == 0) // anon function, a for loop in imperative
                .boxed() // collect requires this
                .collect(Collectors.toSet()); // add(collect) all to set

        return divisorSet;
    }
    public static void main(String[] args)
    {
        System.out.println(PerfectNumber.process(6));
        System.out.println(PerfectNumber.process(1));
        System.out.println(PerfectNumber.process(20));
        return;
    }
}
