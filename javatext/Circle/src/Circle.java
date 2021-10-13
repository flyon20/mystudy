public class Circle {
    private double radius;
    private int id;
    public Circle(){
        id=init++;
        total++;
    }
    public Circle(double radius){
        id=init++;
        total++;
    }

    public double getRadius() {
        return radius;
    }

    public static int getTotal() {
        return total;
    }

    public static int getInit() {
        return init;
    }

    public static void setInit(int init) {
        Circle.init = init;
    }

    public static void setTotal(int total) {
        Circle.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    private static int total;
    private static int init;

    public double fingArea(){
        return 3.14*radius*radius;
    }

    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle();
        System.out.println("c1:"+c1.id);

        System.out.println("个数"+Circle.total);
    }
}
