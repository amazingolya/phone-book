package phonebook;

public class Contact {
    private final int number;
    private final String name;

    public Contact(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}

