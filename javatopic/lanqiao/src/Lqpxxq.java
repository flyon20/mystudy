/*
* 题目描述
小蓝有黄绿蓝三种颜色的小球，分别为 R, G, B 。同样颜色的小球没有区别。
小蓝将这些小球从左到右排成一排，排完后，将最左边的连续同色小球个数记为 t1，将接下来的连续小球个数记为t2，以此类推直到最右边的小球。请问，总共有多少总摆放小球的方案，使得 t1 ,t2,⋯ 为严格单调递增序列，即t1≤t2≤t3≤⋯。
输入描述
输入一行包含三个整数 R, G, B。
其中，0≤R,G,B≤50。。
输出描述
输出一个整数，表示答案。
输入输出样例
输入
3 6 0
输出
3
样例说明
用 r 表示红球，g 表示绿球，可能的方案包括：
rrrgggggg
grrrggggg
ggrrrgggg
*/
import java.util.Scanner;
public class Lqpxxq {

        static int sum=0;
        static boolean check(int a[]) {
            int old=0;
            int now=1;
            for (int i = 0; i < a.length-1; i++) {
                if(a[i]==a[i+1]) {
                    now++;
                }else {
                    if(old>=now) {
                        return false;
                    }
                    old=now;
                    now=1;
                }
            }
            if(old>=now) return false;
            else return true;
        }
        static void dfs(int a[],int r,int g,int b,int k){
            if(k==a.length) {
                if(check(a)) {
                    sum++;
                }
            }

            if(r>0) {
                a[k]=1;
                dfs(a,r-1,g,b,k+1);
            }
            if(g>0) {
                a[k]=2;
                dfs(a,r,g-1,b,k+1);
            }
            if(b>0) {
                a[k]=3;
                dfs(a,r,g,b-1,k+1);
            }
        }
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner sc = new Scanner(System.in);
            int r=sc.nextInt();
            int g=sc.nextInt();
            int b=sc.nextInt();
            int a[]=new int[r+g+b];

            dfs(a,r,g,b,0);
            System.out.print(sum);

        }

}