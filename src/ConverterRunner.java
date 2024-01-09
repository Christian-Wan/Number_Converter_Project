import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int base = 0;

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

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        int n = Integer.parseInt(number);

        s.close();

        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());
        System.out.println();

        System.out.println(nc.conversions());
    }
}

