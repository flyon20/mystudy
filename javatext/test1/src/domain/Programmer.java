package domain;

import service.Status;

public class Programmer extends Employee {
    private int memberId;
    private Status status;
    private Equipment equipment;

    public Programmer() {
        this.status = Status.FREE;
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.status = Status.FREE;
        this.equipment = equipment;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return this.equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public int getMemberId() {
        return this.memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    protected String getMemberDetails() {
        return this.getMemberId() + "/" + this.getDetails();
    }

    public String getDetailsForTeam() {
        return this.getMemberDetails() + "\t程序员";
    }

    public String toString() {
        return this.getDetails() + "\t程序员\t" + this.status + "\t\t\t" + this.equipment.getDescription();
    }
}
