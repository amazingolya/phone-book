import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int[] numbers = new int[k];
        for (int i = 0; i < k; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.close();
        printArray(findNumbers(array, numbers));
    }

    public static int findNumber(int[] array, int number) {
        int left = 0;
        int right = array.length;
        while (left != right - 1) {
            int middle = left + (right - left) / 2;
            if (array[middle] == number) {
                return middle + 1;
            }
            if (array[middle] > number) {
                right = middle;
            } else {
                left = middle;
            }
        }
        if (array[left] == number) {
            return left + 1;
        }
        return -1;
    }

    public static int[] findNumbers(int[] array, int[] numbers) {
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = findNumber(array, numbers[i]);
        }
        return result;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(" ");
            }
        }
    }
}