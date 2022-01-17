/*
* 在电子计算机普及以前，人们经常用一个粗略的方法来验算四则运算是否正确。
比如：248 \times 15 = 3720248×15=3720
把乘数和被乘数分别逐位求和，如果是多位数再逐位求和，直到是 1 位数，得
2 + 4 + 8 = 14 ==> 1 + 4 = 52+4+8=14==>1+4=5；
1 + 5 = 61+5=6；
5 \times 65×6
而结果逐位求和为 3。
5 \times 65×6 的结果逐位求和与 3 符合，说明正确的可能性很大！！（不能排除错误）
请你写一个计算机程序，对给定的字符串逐位求和。*/
import java.util.Scanner;
public class Lqshuoweiqiuhe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        while (s.length() > 1){
            long ans = 0;
            for (int i = 0; i < s.length(); i++){
                ans += s.charAt(i) - '0';
            }
            s = "" + ans;
        }
        System.out.println(s);
    }
}
