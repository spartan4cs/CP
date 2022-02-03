import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableMain {
    public static void main(String[] args) {

        List<Employee> e = new ArrayList<>();
        Employee e1 = new Employee("akash", 28, 75000);
        Employee e2 = new Employee("akash", 26, 75000);
        Employee e3 = new Employee("akash", 28, 76000);
        e = Arrays.asList(e1, e2, e3);
        Collections.sort(e);
        e.forEach(f -> System.out.println(f));
    }
}