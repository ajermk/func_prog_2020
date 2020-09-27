package imperativeSolution;

import java.util.*;

public class PerfectNumber
{
    public static STATE process(int n)
    {
        int divisorSum = 0;
        Set<Integer> divisorSet = divisors(n);

        for (Integer i : divisorSet)
            divisorSum += i;

        if (divisorSum == n)
            return STATE.PERFECT;
        else if (divisorSum > n)
            return STATE.ABUNDANT;
        else if (divisorSum < n)
            return STATE.DEFICIENT;
        else return null; // in case of error or smth
    }
    public static Set<Integer> divisors(int n)
    {
        Set<Integer> divisorSet = new HashSet<Integer>();
                                        /* add divisors until input number but dont check the number itself */
        for (int i = 1; i < n; i++)     /* start from i=i because 0 is not a positive int */
            if (n % i == 0)
                divisorSet.add(i);


        return divisorSet;
    }
}
