public class ArrayTest {
    public static void main(String[] args) {
        Arrayutil1 arr1= new Arrayutil1();
        Arrayutil1 arr2= new Arrayutil1("advsm",3000);

        Arrayutil1.setInterestRate(0.012);
        Arrayutil1.setMinMoney(1000);

        System.out.println(arr1);
        System.out.println(arr2);
        System.out.println(arr1.getInterestRate());
        System.out.println(arr2.getMinMoney());


    }
}
