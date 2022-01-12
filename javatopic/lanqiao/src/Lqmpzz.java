/*
* 门牌制作
本题总分：5 分
【问题描述】
小蓝要为一条街的住户制作门牌号。
这条街一共有 2020 位住户，门牌号从 1 到 2020 编号。
小蓝制作门牌的方法是先制作 0 到 9 这几个数字字符，最后根据需要将字
符粘贴到门牌上，例如门牌 1017 需要依次粘贴字符 1、0、1、7，即需要 1 个
字符 0，2 个字符 1，1 个字符 7。
请问要制作所有的 1 到 2020 号门牌，总共需要多少个字符 2？
*/
public class Lqmpzz {
    public static void main(String[] args) {
        //在此输入您的代码...
        int a = 0;
        int n = 0;
        for(int i = 2 ; i <= 2020 ; i ++) {
            n = i;
            while(n>10){
                if(n%10 == 2) {
                    a ++;
                }
                n /= 10;
            }
            if(n == 2) {
                a ++;
            }
        }
        System.out.println(a);
    }
}