/*
* 如果整数 aa 是整数 bb 的整数倍，则称 bb 是 aa 的约数。

请问，有多少个正整数既是 20202020 的约数，又是 30303030 的约数。*/
public class Lqgongyueshu {
    public static void main(String[] args) {
        //在此输入您的代码...
        int count=0;
        for(int i=1;i<=3030;i++){
            if((2020%i==0)&&(3030%i==0)){
                count++;
            }
        }
        System.out.println(count);
    }
}
