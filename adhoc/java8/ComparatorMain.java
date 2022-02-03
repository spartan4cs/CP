import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparatorMain {
    public static void main(String[] args) {
        List<Employee1> e = new ArrayList<>();
        Employee1 e1 = new Employee1("akash", 28, 75000);
        Employee1 e2 = new Employee1("akash", 26, 75000);
        Employee1 e3 = new Employee1("akash", 28, 76000);
        e = Arrays.asList(e1, e2, e3);
        Collections.sort(e, new SortByNameAgeSalary());
        e.forEach(f -> System.out.println(f));
    }
}
