
import static java.lang.System.in;

class Prime {
    // The 'int... numbers' syntax allows the method to accept any number of integers
    public void checkPrime(int... numbers) {
        for (int num : numbers) {
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println(); // Move to a new line after each set of arguments
    }

    // Helper method to determine if a number is prime
    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

