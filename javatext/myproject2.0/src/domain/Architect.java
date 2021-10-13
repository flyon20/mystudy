package domain;

public class Architect extends Designer{
    private int stock;

    public Architect() {
    }

    public Architect(int id, String name, int age, Double salary, Equipment equipment, double bouns, int stock) {
        super(id, name, age, salary, equipment, bouns);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

//    public Architect(double bonus) {
//        super(bonus);
//    }

//    public Architect(double bonus, int stock) {
//        super(bonus);
//        this.stock = stock;
//    }
    @Override
    public String toString() {
        return getDetails()+"\t架构师\t"+getStatus()+"\t"+getBonus()+"\t"+stock+"\t"+getEquipment().getDescription();
    }
    public String getDetailsForTeam(){
        return getMemberId()+"\t"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t架构师"+getBonus()+getStock();
    }
}
