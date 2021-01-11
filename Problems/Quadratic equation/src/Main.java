import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = Math.sqrt(b * b - 4 * a * c);
        double r1 = (-b - d) / (2 * a);
        double r2 = (-b + d) / (2 * a);
        System.out.print(Math.min(r1, r2) + " ");
        System.out.println(Math.max(r1, r2));
    }
}