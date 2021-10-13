public class Arrayutil1 {
    private int id;
    private String pwd="000000";
    private double blance;

    private static double interestRate;
    private static int init=1001;

    public Arrayutil1(){
        id=init++;
    }
    public Arrayutil1(String pwd,double blance){
        id=init++;
        this.pwd=pwd;
        this.blance=blance;
    }
    public int getId() {
        return id;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        Arrayutil1.interestRate = interestRate;
    }

    public static double getMinMoney() {
        return minMoney;
    }

    public static void setMinMoney(double minMoney) {
        Arrayutil1.minMoney = minMoney;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getBlance() {
        return blance;
    }

    public void setBlance(double blance) {
        this.blance = blance;
    }

    @Override
    public String toString() {
        return "Arrayutil1{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                ", blance=" + blance +
                '}';
    }

    private static double minMoney=1.0;

}
