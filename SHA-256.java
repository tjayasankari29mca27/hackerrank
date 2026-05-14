import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        
        try {
            // Create MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            // Compute the hash
            byte[] digest = md.digest(input.getBytes());
            
            // Convert byte array to hexadecimal string
            for (byte b : digest) {
                System.out.format("%02x", b);
            }
            System.out.println();
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
