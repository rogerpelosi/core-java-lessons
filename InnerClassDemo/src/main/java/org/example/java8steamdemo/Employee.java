package org.example.java8steamdemo;

public class Employee {

    private int id;
    private String fname;
    private int salary;
    private String city;

    public Employee(int id, String fname, int salary, String city) {
        this.id = id;
        this.fname = fname;
        this.salary = salary;
        this.city = city;
    }

    public Employee(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", salary=" + salary +
                ", city='" + city + '\'' +
                '}';
    }
}
