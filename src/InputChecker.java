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
}
