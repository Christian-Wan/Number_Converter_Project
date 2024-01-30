import java.util.ArrayList;

public class InputChecker {

    public static boolean checkInteger(int[] acceptable, int input) {
        for (int i = 0; i < acceptable.length; i++) {
            if (acceptable[i] == input) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkNumber(char[] acceptable, String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!contains(acceptable, input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean contains(char[] acceptable, char input) {
        for (int i = 0; i < acceptable.length; i++) {
            if (acceptable[i] == input) {
                return true;
            }
        }
        return false;
    }
}
