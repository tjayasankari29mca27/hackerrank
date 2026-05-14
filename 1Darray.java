import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        return isSolvable(leap, game, 0);
    }
    private static boolean isSolvable(int leap, int[] game, int i) {
        // 1. If index is >= length, you've jumped off the end and won!
        if (i >= game.length) {
            return true;
        }
        // 2. If index is negative or the cell contains a 1, this path is invalid
        if (i < 0 || game[i] == 1) {
            return false;
        }

        // Mark the current cell as visited to prevent walking in circles
        game[i] = 1;

        // 3. Try all 3 possible moves recursively:
        // Jump forward (i + leap), Walk forward (i + 1), Walk backward (i - 1)
        return isSolvable(leap, game, i + leap) || 
               isSolvable(leap, game, i + 1) || 
               isSolvable(leap, game, i - 1);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
