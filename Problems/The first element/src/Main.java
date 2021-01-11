// do not remove imports

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ArrayUtils {
    public static <T> T getFirst(T[] t) {
        return t.length == 0 ? null : t[0];
    }
}