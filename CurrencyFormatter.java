import java.util.*;
import java.text.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        // Write your code here.
                // Create NumberFormat instances for each Locale
        NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat cnFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat frFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        
        // Create a custom Locale for India (English language, India country)
        Locale indiaLocale = new Locale("en", "IN");
        NumberFormat inFormat = NumberFormat.getCurrencyInstance(indiaLocale);

        // Format the payment value
        String us = usFormat.format(payment);
        String india = inFormat.format(payment);
        String china = cnFormat.format(payment);
        String france = frFormat.format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
