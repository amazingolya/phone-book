package phonebook;

public class PhoneBook {
    public static Contact[] createContactBook(String[] textBook) {
        Contact[] phoneBook = new Contact[textBook.length];
        for (int i = 0; i < textBook.length; i++) {
            String[] info = textBook[i].split(" ");
            StringBuilder name = new StringBuilder();
            for (int j = 1; j < info.length; j++) {
                name.append(info[j]);
                if (j == info.length - 1) {
                    break;
                }
                name.append(" ");
            }
            phoneBook[i] = new Contact(Integer.parseInt(info[0]), name.toString());
        }
        return phoneBook;
    }
}
