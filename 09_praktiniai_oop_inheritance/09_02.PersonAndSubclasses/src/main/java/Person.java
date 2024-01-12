public class Person {
    private String fullName;
    private String address;

    public Person(String fullName, String address) {
        this.fullName = fullName;
        this.address = address;
    }

    @Override
    public String toString() {
        return fullName + "\n  "+ address;
    }
}
