import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine(); // Consume the newline character
        
        // 1. Initialize the phone book using a HashMap
        Map<String, Integer> phoneBook = new HashMap<>();
        
        for(int i = 0; i < n; i++)
        {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine(); // Consume the newline character
            phoneBook.put(name, phone);
        }
        
        // 2. Process queries until EOF (End Of File)
        while(in.hasNext())
        {
            String s = in.nextLine();
            if (phoneBook.containsKey(s)) {
                // If found, print name=number
                System.out.println(s + "=" + phoneBook.get(s));
            } else {
                // If not found, print Not found
                System.out.println("Not found");
            }
        }
        in.close();
    }
}
