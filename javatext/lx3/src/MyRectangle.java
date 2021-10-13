public class MyRectangle extends GeometricObject{
    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double findArea() {
        return width*height;
    }

    public MyRectangle(double width, double height, String color, double weight) {
        super(color, weight);
        this.height=height;
        this.width=width;
    }

}
