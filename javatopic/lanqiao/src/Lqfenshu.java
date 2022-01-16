/*
* 1/1 + 1/2 + 1/4 + 1/8 + 1/16 + …
每项是前一项的一半，如果一共有20项,
求这个和是多少，结果用分数表示出来。*/
public class Lqfenshu {
    public static void main(String[] args) {
        long a = 2;
        long b = 2;
        int i;
        for(i=1;i<=18;i++)
        {
            a*=2;
            b*=2;
        }
        a*=2;
        a=a-1;
        for(i=2;i<Math.sqrt(a);i++)
        {
            if(a%i==0 && b%i==0)
            {
                a/=i;
                b/=i;
            }
        }
        System.out.println(a+"/"+b);
    }
}
