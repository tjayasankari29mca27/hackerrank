import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Size of bitsets
        int m = sc.nextInt(); // Number of operations
        
        // Create an array to hold BitSets for easy 1-based indexing
        BitSet[] bitsets = new BitSet[3];
        bitsets[1] = new BitSet(n);
        bitsets[2] = new BitSet(n);
        
        for (int i = 0; i < m; i++) {
            String op = sc.next();
            int arg1 = sc.nextInt();
            int arg2 = sc.nextInt();
            
            switch (op) {
                case "AND":
                    bitsets[arg1].and(bitsets[arg2]);
                    break;
                case "OR":
                    bitsets[arg1].or(bitsets[arg2]);
                    break;
                case "XOR":
                    bitsets[arg1].xor(bitsets[arg2]);
                    break;
                case "FLIP":
                    bitsets[arg1].flip(arg2);
                    break;
                case "SET":
                    bitsets[arg1].set(arg2);
                    break;
            }
            
            // Print the number of set bits (cardinality) in B1 and B2
            System.out.println(bitsets[1].cardinality() + " " + bitsets[2].cardinality());
        }
        sc.close();
    }
}
