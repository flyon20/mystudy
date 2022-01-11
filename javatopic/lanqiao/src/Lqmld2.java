/*
* 小蓝特别喜欢 22，今年是公元 20202020 年，他特别高兴。 他很好奇，在公元 11 年到公元 20202020 年（包含）中，
* 有多少个年份的数位中包含数字 22？*/
public class Lqmld2 {
    public static void main(String[] args) {
        //在此输入您的代码...
        int n=2020;
        int sum=0;
        for (int i = 1; i <= n; i++) {
            if (i%10==2||i/10%10==2||i/100%10==2||i/1000==2) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
