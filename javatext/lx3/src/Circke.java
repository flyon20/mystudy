public class Circke extends GeometricObject{
    private  double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circke(double radius,String color, double weight) {
        super(color, weight);
        this.radius=radius;
    }
    public double findArea(){
        return 3.14*radius*radius;
    }


}
