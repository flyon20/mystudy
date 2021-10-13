public class Texttry extends Text1 implements Text{

    @Override
    public String Text1() {
        return "子类修改，继承！";
    }

    @Override
    public String gettexttry() {

       return  "测试多态！"+Text1();
    }
}
class Text2 extends Text1{
    @Override
    public String Text1() {
        return super.Text1();
    }
}