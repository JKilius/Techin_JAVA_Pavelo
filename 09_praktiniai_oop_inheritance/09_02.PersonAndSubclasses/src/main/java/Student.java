public class Student extends Person {
    private int credit;

    public Student(String fullName, String address) {
        super(fullName, address);
        credit = 0;
    }

    public void study() {
        credit++;
    }
    public int credits(){
        return credit;
    }

    @Override
    public String toString() {
        return super.toString() + "\n  " + "Study credits " + credit;
    }

}
