package domain;

public class Employee {
    private String name;
    private int id;
    private int age;
    private double salary;


    public Employee() {
    }

    public Employee(int id,String name,int age,double salary) {
        this.id=id;
        this.name=name;
        this.age=age;
        this.salary=salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
    public String getDetails(){
        return id+"\t"+name+"\t"+age+"\t"+salary;
    }
    @Override
    public String toString() {
        return getDetails();
    }
}
