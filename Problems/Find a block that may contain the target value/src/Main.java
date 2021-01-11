import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int value = scanner.nextInt();
        int rightBorder = findRightBorder(array, value);
        if (rightBorder == -1) {
            System.out.println(-1);  
        } else {
            System.out.println(findLeftBorder(rightBorder, n) + " " + rightBorder);
        } 
    }

    public static int findRightBorder(int[] array, int value) {
        int n = array.length;
        int step = (int) Math.sqrt(n);
        int current = 2;
        while (current < n) {
            if (value <= array[current]) {
                return current;
            }

            current += step;
            if (current >= n && value <= array[n - 1]) {
                return n - 1;
            }
        }
        return -1;
    }
    public static int findLeftBorder(int rightBorder, int arrayLength) {
        if (rightBorder == arrayLength - 1) {
            return rightBorder;
        } else if (rightBorder == 2) {
            return 0;
        } else {
            return rightBorder + 1 - (int) Math.sqrt(arrayLength);
        }
    
    }
}
