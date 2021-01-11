package phonebook;

public class JumpSearch {
    public static long findEntries(Contact[] phoneBook, String[] fullNames) {
        long entries = 0;
        for (String key: fullNames) {
            if (isFound(phoneBook, key)) {
                entries++;
            }
        }
        return entries;
    }

    public static boolean isFound(Contact[] phoneBook, String target) {
        int currentRight = 0;
        int prevRight = 0;
        if (phoneBook.length == 0) {
            return false;
        }
        if (phoneBook[currentRight].getName().equals(target)) {
            return true;
        }
        int jumpLength = (int) Math.sqrt(phoneBook.length);

        while (currentRight < phoneBook.length - 1) {
            currentRight = Math.min(phoneBook.length - 1, currentRight + jumpLength);

            if (phoneBook[currentRight].getName().compareTo(target) >= 0) {
                break;
            }
            prevRight = currentRight;
        }
        if ((currentRight == phoneBook.length - 1) && target.compareToIgnoreCase(phoneBook[currentRight].getName()) > 0) {
            return false;
        }
        return LinearSearch.isFound(phoneBook, target, prevRight, currentRight);
    }
}
