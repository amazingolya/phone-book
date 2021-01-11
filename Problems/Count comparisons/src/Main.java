import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int targetValue = scanner.nextInt();
        scanner.close();
        System.out.println(findComparisons(array, targetValue));
    }

    public static int findComparisons(int[] array, int target) {
        final int n = array.length;
        final int step = (int) Math.sqrt(n);
        if (array[0] >= target || n == 1) {
            return 1;
        }
        int border = step;
        int counter = 2;

        while (border < n) {
            if (array[border] == target) {
                return counter;
            }
            if (array[border] > target) {
                return counter + linearSearch(array, border, target);
            }
            if (border == n - 1) {
                return counter;
            }
            border += step;
            counter++;
        }

        return counter - 1 + linearSearch(array, n, target);
    }

    public static int linearSearch(int[] array, int border, int value) {
        int count = 0;
        int step = (int) Math.sqrt(array.length);
        int right = border - 1;
        int left = border - step;
        for (int i = right; i > left; i--) {
            count++;
            if (value >= array[i]) {
                return count;
            }
        }
        return count;
    }
}