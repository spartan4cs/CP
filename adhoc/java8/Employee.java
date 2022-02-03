public class Employee implements Comparable<Employee> {
    String name;
    int age;
    int salary;

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee e) {
        int name = this.getName().compareTo(e.getName());
        if (name != 0) {
            return name;
        }
        int age = this.getAge() - e.getAge();
        if (age != 0) {
            return age;
        }
        int salary = this.getSalary() - e.getSalary();
        return salary;

    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", age='" + getAge() + "'" +
                ", salary='" + getSalary() + "'" +
                "}";
    }

}
