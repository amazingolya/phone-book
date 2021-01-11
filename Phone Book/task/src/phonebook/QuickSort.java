package phonebook;

public class QuickSort {
    public static void quickSort(Contact[] array) {
        quickSort(array, 0, array.length - 1);
    }
    public static void quickSort(Contact[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }
    private static int partition(Contact[] array, int left, int right) {

        String pivot = array[right].getName();
        int partitionIndex = left;


        for (int i = left; i < right; i++) {
            if (pivot.compareToIgnoreCase(array[i].getName()) >= 0) {
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }

        swap(array, partitionIndex, right);

        return partitionIndex;
    }

    private static void swap(Contact[] array, int i, int j) {
        Contact temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
