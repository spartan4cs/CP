import java.util.Comparator;

public class SortByNameAgeSalary implements Comparator<Employee1> {

    @Override
    public int compare(Employee1 o1, Employee1 o2) {
        int name = o1.getName().compareTo(o2.getName());
        if (name != 0) {
            return name;
        }
        int age = o1.getAge() - o2.getAge();
        if (age != 0) {
            return age;
        }
        int salary = o1.getSalary() - o2.getSalary();
        return salary;
    }

}
