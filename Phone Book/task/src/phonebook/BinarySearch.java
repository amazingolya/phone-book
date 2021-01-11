package phonebook;

public class BinarySearch {
    public static long findEntries(Contact[] phoneBook, String[] fullNames) {
        long entries = 0;
        for (String key : fullNames) {
            if (binarySearch(phoneBook, key) != -1) {
                entries++;
            }
        }
        return entries;
    }

    public static int binarySearch(Contact[] array, String element) {
        return binarySearch(array, element, 0, array.length);
    }

    public static int binarySearch(Contact[] array, String element, int left, int right) {
        if (left > right) return -1;
        int middle = left + (right - left) / 2;
        if (element.compareToIgnoreCase(array[middle].getName()) == 0) return middle;
        if (element.compareToIgnoreCase(array[middle].getName()) < 0) return binarySearch(array, element, left, middle - 1);
        else return binarySearch(array, element, middle + 1, right);
    }
}
