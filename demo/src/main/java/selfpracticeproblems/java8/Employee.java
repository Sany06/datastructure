package selfpracticeproblems.java8;

public class Employee {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
    String name;
    String dept;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    int salary;

    public Employee(String name, String dept, int salary) {
    this.name=name;
    this.dept=dept;
    this.salary=salary;
    }


}
