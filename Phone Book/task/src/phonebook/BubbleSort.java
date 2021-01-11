package phonebook;

public class BubbleSort {

    public static boolean sort(Contact[] phoneBook, long timeout) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < phoneBook.length - 1; i++) {
            for (int j = 0; j < phoneBook.length - i - 1; j++) {
                if (System.currentTimeMillis() - start > timeout) {
                    return false;
                }
                if (phoneBook[j].getName().compareToIgnoreCase(phoneBook[j + 1].getName()) > 0) {
                    Contact temp = phoneBook[j];
                    phoneBook[j] = phoneBook[j + 1];
                    phoneBook[j + 1] = temp;
                }
            }
        }
        return true;
    }
}