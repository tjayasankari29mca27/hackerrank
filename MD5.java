import java.io.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String s = sc.next();
        sc.close();
        
        try {
            // Initialize the MessageDigest instance with MD5 algorithm
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            // Compute the message digest array of bytes
            byte[] digest = md.digest(s.getBytes());
            
            // Convert byte array into a signum representation
            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                // Convert byte to hex format and pad with a leading zero if necessary
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            // Print the final 32-character hexadecimal hash
            System.out.println(hexString.toString());
            
        } catch (NoSuchAlgorithmException e) {
            // Exception thrown if MD5 provider is missing from the environment
            e.printStackTrace();
        }
    }
}
