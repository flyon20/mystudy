/*
* 小蓝要和朋友合作开发一个时间显示的网站。
在服务器上，朋友已经获取了当前的时间，用一个整数表示，值为从 19701970 年 11 月 11 日 00:00:0000:00:00
* 到当前时刻经过的毫秒数。
现在，小蓝要在客户端显示出这个时间。小蓝不用显示出年月日，只需要显示出时分秒即可，毫秒也不用显示，直接舍去即可。
给定一个用整数表示的时间，请将这个时间对应的时分秒输出。*/
import java.util.Scanner;

public class Lq2021 {
    public static String tos(long x){
        if(x<10)return "0"+x;
        else return ""+x;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        n%=(1000*60*60*24);
        n/=1000;
        System.out.println(tos(n/3600)+":"+tos((n/60)%60)+":"+tos(n%60));
    }
}