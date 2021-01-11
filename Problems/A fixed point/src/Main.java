import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(containsFixedPoint(array, 0, n));
    }

    public static boolean containsFixedPoint(int[] array, int left, int right) {
        if (array.length == 0) {
            return false;
        }
        if (left == right - 1) {
            return array[left] == left;
        }
        int middle = left + (right - left) / 2;
        if (array[middle] == middle) {
            return true;
        }
        if (array[middle] > middle) {
            return containsFixedPoint(array, left, middle);
        } else {
            return containsFixedPoint(array, middle, right);
        }
    }
}