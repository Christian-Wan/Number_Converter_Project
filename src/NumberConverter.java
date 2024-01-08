public class NumberConverter {
    int[] digits;
    int base;

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
        else {
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] != 0) {
                    number += digits[i] * Math.pow(8, digits.length - 1 - i);
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


        for (int i = highest; highest >= 0; i--) {
            if (original > Math.pow(2, highest)) {
                original -= Math.pow(2, highest);
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
        for (int i = highest; highest >= 0; i--) {
            if (original > Math.pow(8, highest)) {
                for (int x = 8; x > 0; x++) {
                    if (original > i * Math.pow(8, highest)) {
                        original -= i * Math.pow(8, highest);
                        number += i;
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

    public String conversions() {
        String printing = "";
        if (base == 10) {
            printing = "Binary number: " + convertToBinary() +
                    "\nOctal number: " + convertToOctal();
        }
        else if (base == 8) {
            printing = "Binary number: " + convertToBinary() +
                    "\nDecimal number: " + convertToDecimal();
        }
        else {
            printing = "Octal number: " + convertToOctal() +
                    "\nDecimal number: " + convertToDecimal();
        }
        return printing;
    }

}

