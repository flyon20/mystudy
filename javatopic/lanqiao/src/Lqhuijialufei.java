/*
* 小明被不明势力劫持。后莫名其妙被扔到 X 星站再无问津。小明得知每天都有飞船飞往地球，但需要 108108 元的船票，而他却身无分文。
他决定在 X 星战打工。好心的老板答应包食宿，第 11 天给他 11 元钱。 并且，以后的每一天都比前一天多 22 元钱，直到他有足够的钱买票。
* 请计算一下，小明在第几天就能凑够 108108 元，返回地球。*/
public class Lqhuijialufei {
    public static void main(String[] args) {
        //在此输入您的代码...
        int a=1,i;
        int sum=1;

        for( i=1;sum<=108;i++){
            a+=2;
            sum+=a;
        }
        System.out.println(i);
    }
}
