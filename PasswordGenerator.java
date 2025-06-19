import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {

    public static String generatePassword(int length, boolean useUpper, boolean useLower,
                                          boolean useDigits, boolean useSymbols) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String symbols = "!@#$%^&*()-_+=<>?/";

        String characterPool = "";

        if (useUpper) characterPool += upper;
        if (useLower) characterPool += lower;
        if (useDigits) characterPool += digits;
        if (useSymbols) characterPool += symbols;

        if (characterPool.isEmpty()) {
            return "Error: No character types selected!";
        }

        StringBuilder password = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🔐 Java Password Generator 🔐");

        System.out.print("Enter password length: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (y/n): ");
        boolean useUpper = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean useLower = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include digits? (y/n): ");
        boolean useDigits = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include symbols? (y/n): ");
        boolean useSymbols = scanner.next().equalsIgnoreCase("y");

        String password = generatePassword(length, useUpper, useLower, useDigits, useSymbols);
        System.out.println("\nGenerated Password: " + password);
    }
}
