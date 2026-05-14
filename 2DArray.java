import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        bufferedReader.close();
        int maxHourglassSum = Integer.MIN_VALUE;

        // Loop through all 16 valid top-left anchoring positions (indices 0 to 3)
        for (int r = 0; r <= 3; r++) {
            for (int c = 0; c <= 3; c++) {
                
                // Extract elements using row list indexing and item position fetching
                int topRow = arr.get(r).get(c) + arr.get(r).get(c + 1) + arr.get(r).get(c + 2);
                int middleRow = arr.get(r + 1).get(c + 1);
                int bottomRow = arr.get(r + 2).get(c) + arr.get(r + 2).get(c + 1) + arr.get(r + 2).get(c + 2);
                
                int currentSum = topRow + middleRow + bottomRow;

                // Track the maximum sum found across the iterations
                if (currentSum > maxHourglassSum) {
                    maxHourglassSum = currentSum;
                }
            }
        }

        // Print the highest calculated hourglass sum to stdout
        System.out.println(maxHourglassSum);
    
    }
}
