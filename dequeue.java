import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            
            // Add current number to deque and set
            deque.add(num);
            set.add(num);

            // When the window reaches size M
            if (deque.size() == m) {
                // Update maximum unique count found so far
                if (set.size() > maxUnique) {
                    maxUnique = set.size();
                }
                
                // If we've reached the theoretical max (M), we can exit early
                if (maxUnique == m) break;

                // Prepare for next window: remove the first element
                int first = deque.removeFirst();
                // Only remove from Set if that number is no longer in the current Deque
                if (!deque.contains(first)) {
                    set.remove(first);
                }
            }
        }
        System.out.println(maxUnique);
        in.close();
    }
}
