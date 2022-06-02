package javastudy1;

public class test extends testextend{
    @Override
    public void t() {
        System.out.println("222");
        super.t();
    }

    public static void main(String[] args) {
        test t = new test();
        t.t();
    }
}
