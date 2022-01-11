/*
* 给定数列 1, 1, 1, 3, 5, 9, 17, \cdots1,1,1,3,5,9,17,⋯，从第 44 项开始，每项都是前 33 项的和。

求第 2019032420190324 项的最后 44 位数字。*/
public class Lqshulieqiuzhi {
    public static void main(String[] args) {
        //在此输入您的代码...
        int[] num = new int[20190324];
        num[0] = 1;
        num[1] = 1;
        num[2] = 1;

        for (int i = 3; i <20190324 ; i++) {
            num[i] = num[i-1]+num[i-2]+num[i-3];
            num[i] = num[i]%10000;
        }
        System.out.println(num[20190323]);
    }
}
