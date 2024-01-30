import java.util.Arrays;

public class NumberConverter {
    private char[] digits; //convert this to char
    private int base;
    private int extra;
    private final char[] CONVERSIONS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '+', '/'};

    public NumberConverter(String number, int base, int extra) {
        digits = new char[number.length()];
        for (int i = 0; i < number.length(); i++) {
            char single = number.charAt(i);
            digits[i] = single;
        }
        this.base = base;
        this.extra = extra;
    }

    public int getBase() {
        return base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        return o;
    }

    public char[] getDigits() {
        return digits;
    }

    public int convertToDecimal() {
        int number = 0;
        if (base == 2) {
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] == '1') {
                    number += Math.pow(2, digits.length - 1 - i);
                }
            }
        }
        else if (base == 8) {
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] != '0') {
                    number += Character.getNumericValue(digits[i]) * Math.pow(8, digits.length - 1 - i);
                }
            }
        }
        else {
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] != '0') {
                    number += Arrays.binarySearch(CONVERSIONS, digits[i]) * Math.pow(16, digits.length - 1 - i);
                }
            }
        }
        System.out.println(number);
        return number;
    }

    public String convertToChoice(int transformation) {
        //finds and sets all variables
        String number = "";
        int original = 0;
        if (base == 10) {
            original = Integer.parseInt(displayOriginalNumber());
        }
        else {
            original = convertToDecimal();
        }
        int highest = 0;

        if (transformation != 1) {
            while (original >= Math.pow(transformation, highest)) {
                highest++;
            }
            if (highest != 0) {
                highest--;
            }


            for (int i = highest; i >= 0; i--) {
                if (original >= Math.pow(transformation, i)) {
                    for (int x = transformation; x > 0; x--) {
                        if (original >= x * Math.pow(transformation, i)) {
                            original -= x * Math.pow(transformation, i);
                            number += CONVERSIONS[x];
                            break;
                        }
                    }
                } else {
                    number += "0";
                }
            }
        }
        else {
            for (int i = 0; i < original; i++) {
                number += 1;
            }
        }
        return number;
    }

    public String conversions() {
        String printing = "";
        if (base == 16) {
            printing = "Binary number: " + convertToChoice(2) +
                    "\nOctal number: " + convertToChoice(8) +
                    "\nDecimal number: " + convertToChoice(10);
        }
        else if (base == 10) {
            printing = "Binary number: " + convertToChoice(2) +
                    "\nOctal number: " + convertToChoice(8) +
                    "\nHex number: " + convertToChoice(16);
        }
        else if (base == 8) {
            printing = "Binary number: " + convertToChoice(2) +
                    "\nDecimal number: " + convertToChoice(10) +
                    "\nHex number: " + convertToChoice(16);
        }
        else {
            printing = "Octal number: " + convertToChoice(8) +
                    "\nDecimal number: " + convertToChoice(10) +
                    "\nHex number: " + convertToChoice(16);
        }
        if (extra != 0) {
            printing += "\nBase " + extra + " number: " + convertToChoice(extra);
        }
        return printing;
    }

}

