package main;

public class main {

    public static void main(String[] args)
    {
        System.out.println(palindrome(("abrarba").toLowerCase()));
        System.out.println(palindrome(("Sapalsarītadēdatīraslapas").toLowerCase()));
        System.out.println(palindrome(("Abccb").toLowerCase()));
        System.out.println(palindrome(("stirna").toLowerCase()));
    }

    static boolean palindrome(String s)
    {
        return (s.length() == 0) ? true : palindromeRecursion(s, 0, (s.length() - 1) );
    }
    // takes string, where string begins (at 0) and where string ends
    // recursivly calls method until the entire first half is checked with the second half
    static boolean palindromeRecursion(String s, int i, int j)
    {
        return (i == j) ? true :
                ( (s.charAt(i) != s.charAt(j)) ? false :
                        (
                                (i < j + 1) ? palindromeRecursion(s, i+1, j-1) : true
                        )
                );
    }


}
