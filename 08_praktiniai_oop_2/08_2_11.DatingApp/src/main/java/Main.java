
public class Main {

    public static void main(String[] args) {
        // test your program here

        SimpleDate date = new SimpleDate (29, 12, 2015);

        SimpleDate newDate = date.afterNumberOfDays (7);
        int week = 1;
        while (week <= 7) {

            System.out.println("Friday after " + week + " weeks is " + newDate);
            newDate = newDate.afterNumberOfDays(7);
            week++;
        }
        System.out.println("The date after 790 days from the examined Friday is ...");
        System.out.println("Try "+date.afterNumberOfDays(790));
    }
}
