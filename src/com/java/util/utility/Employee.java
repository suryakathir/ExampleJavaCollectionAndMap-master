package com.java.util.utility;
public class Employee {
    String name;
    int salary;
 
    public Employee(int salary) {
        this.salary = salary;
    }
 
    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
 
    public String toString() {
        return this.name + "-" + salary;
    }
 
    public String getName() {
        return this.name;
    }
 
    public Integer getSalary() {
        return new Integer(this.salary);
    }
 
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            Employee another = (Employee) obj;
            if (this.name.equals(another.name)
                    && this.salary == another.salary) {
                        return true;
            }
        }
 
        return false;
    }
 
    public int hashCode() {
        return 31 * name.hashCode() + salary;
    }
}