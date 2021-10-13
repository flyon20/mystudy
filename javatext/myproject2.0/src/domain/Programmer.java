package domain;

import service.Status;

public class Programmer extends Employee{
    private int memberId;
    private Status status=Status.FREE;
    private Equipment equipment;
    public Programmer(){

    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.status = Status.FREE;
        this.equipment = equipment;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return getDetails()+"\t程序员\t"+status+"\t\t\t"+equipment;
    }

    public String getDetailsForTeam(){
        return memberId+"\t"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t\t程序员";
    }
}
