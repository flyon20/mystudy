import javafx.scene.shape.Circle;

public class GeometricTest {
    public static void main(String[] args) {
        GeometricTest test = new GeometricTest();

        
        test.displayGeometricObject(c1);

    }
    public void displayGeometricObject(GeometricObject o){
        System.out.println("面积为："+o.findArea());
    }



    public boolean equalsArea(GeometricObject o1,GeometricObject o2){
        return o1.findArea()== o2.findArea();
    }
}
