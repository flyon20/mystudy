/*
* 小明对数位中含有 2、0、1、9 的数字很感兴趣（不包括前导 0），在 1 到 40 中这样的数
* 包括 1、2、9、10 至 32、39 和 40，共 28 个，他们的和是 574。
请问，在 1 到 nn 中，所有这样的数的和是多少？
输入描述
输入格式：
输入一行包含两个整数 n（1 \leq n \leq 10^4）n（1≤n≤10 4）。
输出描述
输出一行，包含一个整数，表示满足条件的数的和。
输入输出样例
示例
输入
40
输出
574*/
import java.util.Scanner;
public class Lqtebieshudehe {
    public static void main(String[] args) {


        long sum  = 0;
        int n = new Scanner(System.in).nextInt();
        for (int i = 1; i <= n; i++) {

            if(f(i))
                sum+=i;
        }

        System.out.println(sum);
    }
    public static boolean f( int  n ){
        while(n!=0){
            int t = n%10;
            if(t==2||t==0||t==1||t==9){
                return true;
            }
            n/=10;
        }
        return false;
    }
}
