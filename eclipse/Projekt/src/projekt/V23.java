package projekt;

import java.util.Scanner;

public class V23 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of parts: ");
        int n = scanner.nextInt();
        int[] prints = new int[n];
        System.out.println("Enter the sequence of detector prints (1, -1, or 0):");

        for (int i = 0; i < n; i++) {
            prints[i] = scanner.nextInt();
        }

        calculateCounts(prints);
    }

    public static void calculateCounts(int[] prints) {
        int ship = 0;
        int fix = 0;
        int reject = 0;

        for (int print : prints) {
            if (print == 1) {
                fix++;
            } else if (print == -1) {
                reject++;
            } else if (print == 0) {
                ship++;
            }
        }

        System.out.println(ship + " " + fix + " " + reject);
    }
}
