/*
* 2000 年的 11 月 11 日，是那一年的第 11 天。

那么，20002000 年的 55 月 44 日，是那一年的第几天？*/
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Lqdijitain {
    public static void main(String[] args) {
        //在此输入您的代码...
        long n1,n2;
        Calendar c1=new GregorianCalendar();
        c1.set(2000, 0, 1);
        Calendar c2=new GregorianCalendar();
        c2.set(2000, 4, 4);

        n1=c1.getTimeInMillis();
        n2=c2.getTimeInMillis();
        long day=(n2-n1)/(1000*3600*24);
        System.out.println(day+1);

    }
}
