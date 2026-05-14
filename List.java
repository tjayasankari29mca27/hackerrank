import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        
        // 1. Initialize the List
        int n = scan.nextInt();
        List<Integer> l = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            l.add(scan.nextInt());
        }
        
        // 2. Process Queries
        int q = scan.nextInt();
        for (int i = 0; i < q; i++) {
            String queryType = scan.next();
            if (queryType.equals("Insert")) {
                int index = scan.nextInt();
                int value = scan.nextInt();
                l.add(index, value);
            } else if (queryType.equals("Delete")) {
                int index = scan.nextInt();
                l.remove(index);
            }
        }
        scan.close();
        
        // 3. Print the modified list
        for (Integer num : l) {
            System.out.print(num + " ");
        }
    }
}
