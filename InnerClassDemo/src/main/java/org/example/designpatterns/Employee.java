package org.example.designpatterns;
//impl cloneable is Prototype design pattern
public class Employee implements Cloneable {

    private int id;
    private String name;
    private int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public Employee clone() {
        Employee clone = new Employee(this.id, this.name, this.salary);
        return clone;
//        try {
//            Employee clone = (Employee) super.clone();
//            // TODO: copy mutable state here, so the clone can't change the internals of the original
//            return clone;
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
    }

}

/*

two class: WindowsPlatform & AndroidPlatform
WP -- runWindowApps()
AP -- runAndroidApps()

invoking ap method via wp
-------------------------
windowsPlatform <--> simulator(android apps)
 */
