import java.util.Scanner;

public class GreatestCommonDivisor {

    public static Long GCD (long a, long b){
        long aPrime = a % b;
        if (aPrime == 0)
            return b;

        return GCD(b, aPrime);
    }
    public static void main (String[] args){
//        Using Euclidian Algortithm
//        gcd (a,b) = gcd (a', b) where a' is a remainder of a/b
        Scanner s = new Scanner(System.in);
        long a = s.nextLong();
        long b = s.nextLong();
        long result = GCD(a, b);
        System.out.println(result);
          
    }
}
