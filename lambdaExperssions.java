import java.io.*;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    // Returns a legacy inner class checking if a number is odd
    public PerformOperation isOdd() {
        return new PerformOperation() {
            @Override
            public boolean check(int n) {
                return n % 2 != 0;
            }
        };
    }

    // Returns a legacy inner class executing a loop-optimized primality check
    public PerformOperation isPrime() {
        return new PerformOperation() {
            @Override
            public boolean check(int n) {
                if (n < 2) return false;
                for (int i = 2; i * i <= n; i++) {
                    if (n % i == 0) return false;
                }
                return true;
            }
        };
    }

    // Returns a legacy inner class evaluating palindrome string equivalence
    public PerformOperation isPalindrome() {
        return new PerformOperation() {
            @Override
            public boolean check(int n) {
                String original = Integer.toString(n);
                String reversed = new StringBuilder(original).reverse().toString();
                return original.equals(reversed);
            }
        };
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            PerformOperation op = (ch == 1) ? ob.isOdd() : (ch == 2) ? ob.isPrime() : ob.isPalindrome();
            String ans = (ob.checker(op, num)) ? (ch == 1 ? "ODD" : ch == 2 ? "PRIME" : "PALINDROME") 
                                               : (ch == 1 ? "EVEN" : ch == 2 ? "COMPOSITE" : "NOT PALINDROME");
            System.out.println(ans);
        }
    }
}
