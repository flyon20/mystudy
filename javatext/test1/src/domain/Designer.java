package domain;

public class Designer extends Programmer {
    private double bonus;

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return this.bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getDetailsForTeam() {
        return this.getMemberDetails() + "\t设计师\t" + this.getBonus();
    }

    public String toString() {
        return this.getDetails() + "\t设计师\t" + this.getStatus() + "\t" + this.getBonus() + "\t\t" + this.getEquipment().getDescription();
    }
}
