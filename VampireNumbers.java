import java.util.Scanner;
public class VampireNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input
        System.out.print("Enter the value of m: ");
        int m = scanner.nextInt();
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        // Validate input
        if (m < 1000 || m > 9999 || n < 1000 || n > 9999 || m >= n) {
            System.out.println("INVALID INPUT");
            return;
        }
        // Find and display Vampire numbers
        System.out.println("THE VAMPIRE NUMBERS ARE:");
        int count = 0;
        for (int num = m; num <= n; num++) {
            if (isVampireNumber(num)) {
                System.out.print(num + " ");
                count++;
            }
        }
        // Display frequency
        System.out.println("\nFREQUENCY OF VAMPIRE NUMBER IS: " + count);
    }
    // Check if a number is a Vampire number
    private static boolean isVampireNumber(int num) {
        String strNum = Integer.toString(num);
        int len = strNum.length();
        // Ensure the number is even-digit
        if (len % 2 != 0) {
            return false; // Not an even-digit number
        }
        // Iterate through possible pairs of factors
        for (int i = 10; i <= 99; i++) {
            if (num % i == 0) {
                int factor1 = i;
                int factor2 = num / i;
                String strFactors = Integer.toString(factor1) + Integer.toString(factor2);
                char[] numDigits = strNum.toCharArray();
                char[] factorDigits = strFactors.toCharArray();
                // Check if the digits match
                if (areEqualDigits(numDigits, factorDigits)) {
                    return true; // Found a Vampire number
                }
            }
        }
        return false; // No matching factors found
    }
    // Helper method to check if two sets of digits are equal
    private static boolean areEqualDigits(char[] digits1, char[] digits2) {
        int[] count = new int[10];
        // Count the occurrences of each digit in the first set
        for (char digit : digits1) {
            count[digit - '0']++;
        }
        // Subtract the occurrences of each digit in the second set
        for (char digit : digits2) {
            count[digit - '0']--;
        }
        // If all counts are zero, the sets are equal
        for (int value : count) {
            if (value != 0) {
                return false; // Digits do not match
            }
        }
        return true; // Digits match
    }
}