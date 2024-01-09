package lt.techin;

public class BimBam {


    public static void main(String[] args) {

        bimBam(15);
    }

    /*
    Method prints each number from 1 to number on a new line.
    For each multiple of 3, print "Bim" instead of the number.
    For each multiple of 5, print "Bam" instead of the number.
    For numbers which are multiples of both 3 and 5, print "BimBam" instead of the number.
    1
    2
    Bim
    4
    Bam
    Bim
    .....
    14
    BimBam
    16
    */
    public static void bimBam(int number) {

        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("BimBam");
            } else if (i % 5 == 0) {
                System.out.println("Bam");
            } else if (i % 3 == 0) {
                System.out.println("Bim");
            } else System.out.println(i);

        }
    }
}
