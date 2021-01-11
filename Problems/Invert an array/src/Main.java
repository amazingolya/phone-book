// do not remove imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ArrayUtils {
    public static <T> T[] invert(T[] t) {
        for (int i = 0; i < t.length / 2; i++) {
            T temp = t[i];
            t[i] = t[t.length - 1 - i];
            t[t.length - 1 - i] = temp;
        }
        return t;
    }
}