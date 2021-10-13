public class GeometricObject {
    protected String color;
    protected double weight;

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public GeometricObject(String color,double weight) {
        this.color=color;
        this.weight=weight;
    }
    public double findArea(){
        return 0.0;
    }
}
