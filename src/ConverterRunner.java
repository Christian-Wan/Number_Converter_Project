import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int base = 0;
        int extra = 0;

        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        int[] acceptable = {2, 8, 10, 16};
        do {
            System.out.print("Enter the base of your number (2, 8, 10 or 16): ");
            String choice = s.nextLine();
            try {
                base = Integer.parseInt(choice);
            } catch (NumberFormatException e) {
                base = 0;
            }
        } while (!InputChecker.checkInteger(acceptable, base));


        System.out.println("Would you like to convert to a base from 1 - 64? (\"yes\" = yes, anything else = no)");
        if (s.nextLine().equalsIgnoreCase("yes")) {
            acceptable = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64};
            do {
                System.out.print("Choose a base (1 - 64): ");
                String choice = s.nextLine();
                try {
                    extra = Integer.parseInt(choice);
                } catch (NumberFormatException e) {
                    extra = 0;
                }
            } while (!InputChecker.checkInteger(acceptable, extra));
        }

        String n = "";
        NumberConverter nc = new NumberConverter(n, base, extra);
        char[] acceptableChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '+', '/'};
        do {
            System.out.print("Enter your number: ");
            n = s.nextLine();
            nc = new NumberConverter(n, base, extra);
        } while (!nc.checkValid() || !InputChecker.checkNumber(acceptableChar, n) || n.isEmpty());

        s.close();



        char[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());
        System.out.println();

        System.out.println(nc.conversions());
    }
}

