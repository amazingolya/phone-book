package phonebook;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Contact[] phoneBook = PhoneBook.createContactBook(FileReader.readFromFile("/home/rstk/Downloads/directory.txt"));
            String[] people = FileReader.readFromFile("/home/rstk/Downloads/find.txt");

            System.out.println("Start searching (linear search)...");
            long timeBeforeLinear = System.currentTimeMillis();
            long linearEntries = LinearSearch.findEntries(phoneBook, people);
            long timeAfterLinear = System.currentTimeMillis();
            long secondsLinear = (timeAfterLinear - timeBeforeLinear) / 1000;
            System.out.printf("Found %d / %d entries. Time taken: %d min. %d sec. %d ms.\n", linearEntries, people.length, (secondsLinear / 60), secondsLinear, ((timeAfterLinear - timeBeforeLinear) % 1000));

            searchWithBubbleSort(phoneBook, people, timeBeforeLinear, linearEntries, timeAfterLinear, secondsLinear);
            searchWithQuickSort(phoneBook, people);
            searchWithTable(phoneBook, people);
        } catch (IOException e) {
            System.out.println("Cannot read from file!");
        }
    }

    private static void searchWithBubbleSort(Contact[] phoneBook, String[] people, long timeBeforeLinear, long linearEntries, long timeAfterLinear, long secondsLinear) {
        System.out.println("Start searching (bubble sort + jump search)...");
        long timeBeforeJump = System.currentTimeMillis();
        boolean sortOutcome = BubbleSort.sort(phoneBook, (timeAfterLinear - timeBeforeLinear) * 10);
        long timeAfterSort = System.currentTimeMillis();
        if (!sortOutcome) {
            long stop = (timeAfterSort - timeBeforeJump) / 1000;
            System.out.printf("Found %d / %d entries. Time taken: %d min. %d sec. %d ms.\n", linearEntries, people.length,
                    stop / 60 + secondsLinear / 60, stop + secondsLinear, (timeAfterSort - timeBeforeJump) % 1000 + (timeAfterLinear - timeBeforeLinear) % 1000);
            System.out.printf("Sorting time: %d min. %d sec. %d ms. - STOPPED, moved to linear search\n", stop / 60, stop, (timeAfterSort - timeBeforeJump) % 1000);
            System.out.printf("Searching time: %d min. %d sec. %d ms.\n", (secondsLinear / 60), secondsLinear, (timeAfterLinear - timeBeforeLinear) % 1000);
        } else {
            long entriesJump = JumpSearch.findEntries(phoneBook, people);
            long timeAfterJump = System.currentTimeMillis();
            long secondsJump = (timeAfterJump - timeBeforeJump) / 1000;
            long secondsSort = (timeAfterSort - timeBeforeJump) / 1000;
            long jumpSortTime = (timeAfterJump - timeAfterSort) / 1000;
            System.out.printf("Found %d / %d entries. Time taken: %d min. %d sec. %d ms.\n", entriesJump, people.length, (secondsJump / 60), secondsJump, ((timeAfterJump - timeBeforeJump) % 1000));
            System.out.printf("Sorting time: %d min. %d sec. %d ms.\n", (secondsSort / 60), secondsSort, (timeAfterSort - timeBeforeJump) % 1000);
            System.out.printf("Searching time: %d min. %d sec. %d ms.\n", (jumpSortTime / 60), jumpSortTime, (timeAfterJump - timeAfterSort) % 1000);
        }
    }

    private static void searchWithQuickSort(Contact[] phoneBook, String[] people) {
        System.out.println("Start searching (quick sort + binary search)...");
        long timeBeforeQuick = System.currentTimeMillis();
        QuickSort.quickSort(phoneBook);
        long timeAfterQuick = System.currentTimeMillis();

        long binaryEntries = BinarySearch.findEntries(phoneBook, people);
        long timeAfterBinary = System.currentTimeMillis();

        long secondsQuick = (timeAfterQuick - timeBeforeQuick) / 1000;
        long secondsBinary = (timeAfterBinary - timeAfterQuick) / 1000;
        long totalSeconds = secondsQuick + secondsBinary;

        System.out.printf("Found %d / %d entries. Time taken: %d min. %d sec. %d ms.\n", binaryEntries, people.length, (totalSeconds) / 60, totalSeconds, (timeAfterBinary - timeBeforeQuick) % 1000);
        System.out.printf("Sorting time: %d min. %d sec. %d ms.\n", (secondsQuick / 60), secondsQuick, (timeAfterQuick - timeBeforeQuick) % 1000);
        System.out.printf("Searching time: %d min. %d sec. %d ms.\n", (secondsBinary / 60), secondsBinary, (timeAfterBinary - timeAfterQuick) % 1000);
    }

    private static void searchWithTable(Contact[] phoneBook, String[] people) {
        HashTable<String, Integer> table = new HashTable<>(phoneBook.length);
        System.out.println("Start searching (hash table)...");
        long beforeFilling = System.currentTimeMillis();
        fillTable(table, phoneBook);
        long afterFilling = System.currentTimeMillis();

        long hashTableEntries = findEntries(table, people);
        long afterSearch = System.currentTimeMillis();
        long secHashFill = (afterFilling - beforeFilling) / 1000;
        long secondsSearch = (afterSearch - afterFilling) / 1000;
        long totalHash = secHashFill + secondsSearch;

        System.out.printf("Found %d / %d entries. Time taken: %d min. %d sec. %d ms.\n", hashTableEntries, people.length, (totalHash) / 60, totalHash, (afterSearch - beforeFilling) % 1000);
        System.out.printf("Creating time: %d min. %d sec. %d ms.\n", (secHashFill / 60), secHashFill, (afterFilling - beforeFilling) % 1000);
        System.out.printf("Searching time: %d min. %d sec. %d ms.\n", (secondsSearch / 60), secondsSearch, (afterSearch - afterFilling) % 1000);
    }
    public static long findEntries(HashTable<String, Integer> table, String[] fullNames) {
        long entries = 0;
        for (String key : fullNames) {
            if (table.getValue(key) != null) {
                entries++;
            }
        }
        return entries;
    }

    public static void fillTable(HashTable<String, Integer> table, Contact[] phoneBook) {
        for (Contact contact : phoneBook) {
            table.put(contact.getName(), contact.getNumber());
        }
    }
}
