import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Read the entire line, as strings can contain spaces
        if (!scan.hasNextLine()) {
            System.out.println(0);
            scan.close();
            return;
        }
        
        String s = scan.nextLine();
        scan.close();

        // Trim leading and trailing spaces to prevent empty first tokens
        s = s.trim();

        // Edge case: if the string is empty after trimming, there are 0 tokens
        if (s.length() == 0) {
            System.out.println(0);
            return;
        }

        // Split the string using a regex that matches one or more non-alphabetic characters
        String[] tokens = s.split("[^A-Za-z]+");

        // Print the total number of tokens detected
        System.out.println(tokens.length);

        // Print each individual token on a new line
        for (String token : tokens) {
            System.out.println(token);
        }
    }
}
