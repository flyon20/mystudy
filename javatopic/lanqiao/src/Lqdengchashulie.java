/*
* 数学老师给小明出了一道等差数列求和的题目。但是粗心的小明忘记了一 部分的数列，只记得其中 NN 个整数。
现在给出这 NN 个整数，小明想知道包含这 NN 个整数的最短的等差数列有几项？
输入描述
输入的第一行包含一个整数 NN。
第二行包含 NN 个整数 A_1,A_2,··· ,A_NA并不一定是按等差数列中的顺序给出)
其中，2 \leq N \leq 10^5，0 \leq A_i \leq 10^92≤N≤105，0≤Ai​≤109。
输出描述
输出一个整数表示答案。
输入输出样例
示例
输入
5
2 6 4 10 20
输出
10
样例说明： 包含 2、6、4、10、20 的最短的等差数列是 2、4、6、8、10、12、14、16、 18、20。*/
import java.util.Arrays;
import java.util.Scanner;
public class Lqdengchashulie {
        public static void main(String[] args) {
            Scanner sc =new Scanner(System.in);
            int n = sc.nextInt();
            int [] num = new int [n];			//输入的数
            int [] cha = new int [n-1];			//数组排序后，相邻的数字最小的差值
            for (int i = 0; i < num.length; i++) {
                num[i]=sc.nextInt();
            }
            Arrays.sort(num);					//排序
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < num.length; i++) {
                cha[i-1]=num[i]-num[0];			//相邻数字的差值
                min=Math.min(cha[i-1], min);	//min就是相邻数字最小的差值

            }
            for (int i = 0; i < cha.length; i++) {
                if (cha[i]%min!=0) {			//看相邻数字的最小差值是不是能整除每一个相邻数字的差值
                    min=1;						//如果不能整除，则等差值为1
                    break;
                }

            }
            int temp=0;							//统计最短等差数列的个数
            for (int i = num[0]; i <= num[n-1]; i+=min) {	//i+=min   按照等差值进行上升，直到从最小的数到最大的数
                temp++;

            }


            System.out.println(temp);
        }

    }