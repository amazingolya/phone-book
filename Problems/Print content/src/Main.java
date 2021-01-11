// do not remove imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ArrayUtils {
    public static <T> String info(T[] t) {
        if (t.length == 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(t[0]);
        for (int i = 1; i < t.length; i++) {
            stringBuilder.append(", ")
                    .append(t[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}