package phonebook;

public class LinearSearch {
    public static long findEntries(Contact[] phoneBook, String[] names) {
        long entries = 0;
        for (String fullName : names) {
            for (Contact contact : phoneBook) {
                if (contact.getName().equals(fullName)) {
                    entries++;
                    break;
                }
            }
        }
        return entries;
    }
    public static boolean isFound(Contact[] phoneBook, String fullName, int from, int to) {
        for (int i = to; i > from; i--) {
            if (phoneBook[i].getName().equals(fullName)) {
                return true;
            }
        }
        return false;
    }
}
