import java.util.Arrays;

public class NumberConverter {
    int[] digits; //convert this to char
    int base;

    final char[] CONVERSIONS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '+', '/'};

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int convertToDecimal() {
        int number = 0;
        if (base == 2) {
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] == 1) {
                    number += Math.pow(2, digits.length - 1 - i);
                }
            }
        }
        else if (base == 8) {
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] != 0) {
                    number += digits[i] * Math.pow(8, digits.length - 1 - i);
                }
            }
        }
        else {
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] != 0) {
                    number += Arrays.binarySearch(CONVERSIONS, digits[i]);// refer back to line 4
                }
            }
        }
        return number;
    }

    public int convertToBinary() {
        //Finds and sets all variables
        String number = "";
        int original = 0;
        if (base == 10) {
            original = Integer.parseInt(displayOriginalNumber());
        }
        else {
            original = convertToDecimal();
        }
        int highest = 0;


        while (original >= Math.pow(2, highest)) { //not inf
            highest++;
        }
        if (highest != 0) {
            highest--;
        }


        for (int i = highest; i >= 0; i--) {
            if (original >= Math.pow(2, i)) {
                original -= Math.pow(2, i);
                number += "1";
            }
            else {
                number += "0";
            }
        }
        return Integer.parseInt(number);
    }

    public int convertToOctal() {
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


        while (original >= Math.pow(8, highest)) {
            highest++;
        }
        if (highest != 0) {
            highest--;
        }


        for (int i = highest; i >= 0; i--) {
            if (original >= Math.pow(8, i)) {
                for (int x = 8; x > 0; x--) {
                    if (original >= x * Math.pow(8, i)) {
                        original -= x * Math.pow(8, i);
                        number += x;
                        break;
                    }
                }
            }
            else {
                number += "0";
            }
        }
        return Integer.parseInt(number);
    }

    public int convertToHex() {

    }

    public String conversions() {
        String printing = "";
        if (base == 16) {
            printing = "Binary number: " + convertToBinary() +
                    "\nOctal number: " + convertToOctal() +
                    "\nDecimal number" + convertToDecimal();
        }
        else if (base == 10) {
            printing = "Binary number: " + convertToBinary() +
                    "\nOctal number: " + convertToOctal() +
                    "\nHex number: " + convertToHex();
        }
        else if (base == 8) {
            printing = "Binary number: " + convertToBinary() +
                    "\nDecimal number: " + convertToDecimal() +
                    "\nHex number: " + convertToHex();
        }
        else {
            printing = "Octal number: " + convertToOctal() +
                    "\nDecimal number: " + convertToDecimal() +
                    "\nHex number: " + convertToHex();
        }
        return printing;
    }

}

