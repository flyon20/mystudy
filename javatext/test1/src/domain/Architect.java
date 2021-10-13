package domain;

public class Architect extends Designer {
    private int stock;

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDetailsForTeam() {
        return this.getMemberDetails() + "\t架构师\t" + this.getBonus() + "\t" + this.getStock();
    }

    public String toString() {
        return this.getDetails() + "\t架构师\t" + this.getStatus() + "\t" + this.getBonus() + "\t" + this.getStock() + "\t" + this.getEquipment().getDescription();
    }
}
