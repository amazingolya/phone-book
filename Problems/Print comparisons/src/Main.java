import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 0) {
            System.out.println(0);
        } else {
            printArray(findComparisons(n));
        }

    }

    public static int[] findComparisons(int n) {
        final int step = (int) Math.sqrt(n);
        int[] result = new int[n];
        result[0] = 1;
        int border = step;
        int constant = 2;
        for (int i = 1; i < n; i++) {
            if (i > border) {
                border += step;
                constant++;
            }
            if (border < n) {
                result[i] = constant + border - i;
            } else {
                result[i] = constant + n - i - 1;
            }
        }
        return result;
    }

    public static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(" ");
            }
        }
    }
}