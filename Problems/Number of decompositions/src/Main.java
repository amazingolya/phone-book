import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        decompose(number);
    }

    public static void decompose(int number) {
        decompose(number, number, "");
    }

    public static void decompose(int number, int min, String prefix) {
        if (number == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 1; i <= Math.min(number, min); i++) {
                decompose(number - i, i, prefix + i + " ");
            }
        }
    }
}