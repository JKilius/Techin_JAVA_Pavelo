package lt.techin.oop0;

public class TestEmployee {

    public static  void main (String[] args) {
        Employee employee1 = new Employee(001,"Tomas",
                "Kirkilas", 1000);
        System.out.println(employee1);
        System.out.println(employee1.getAnnualSalary());
        System.out.println(employee1.raiseSalary(10));
        System.out.println(employee1.getAnnualSalary());
        System.out.println(employee1.getName());
    }

}
