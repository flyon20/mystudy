/*
* 小蓝学习了最短路径之后特别高兴，他定义了一个特别的图，希望找到图中的最短路径。
小蓝的图由 2021 个结点组成，依次编号 1 至 2021。
对于两个不同的结点 a, b，如果 a 和 b 的差的绝对值大于 21，则两个结点之间没有边相连；如果 a 和 b 的差的绝对值小于等于 21，则两个点之间有一条长度为 a 和 b 的最小公倍数的无向边相连。
例如：结点 1 和结点 23 之间没有边相连；结点 3 和结点 24 之间有一条无向边，长度为 24；结点 15 和结点 25 之间有一条无向边，长度为 75。
请计算，结点 1 和结点 2021 之间的最短路径长度是多少。
提示：建议使用计算机编程解决问题。
————————————————
版权声明：本文为CSDN博主「212_lee」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/FallenSQL/article/details/115828657*/
import java.text.DecimalFormat;
import java.util.Scanner;

public class Lqlj {
        public static void main(String[] args) {
            int map[][] = new int[2050][2050];//存大点下面初始化的时候不用考虑数据越界

            for(int i=1;i<=2021;i++) {
                for(int j=i;j<=i+21;j++) {
                    //大的数放前面，或者在求最大公约数的时候加一个交换操作
                    map[i][j] = lcm(j,i);
                }
            }
            boolean f[] = new boolean[2050];//用来表示该点是否已经是最短
            int djs[] = new int[2050];//用来存储源点到其他顶点的初始路径
            for(int i=1;i<=2021;i++)djs[i]=map[1][i];

            int min,minIdx=0;
            while(!f[2021]) {//如果2021点的最短路径还没求到就一直循环
                min = Integer.MAX_VALUE;
                for(int i=2;i<=2021;i++) {
                    if(!f[i] && djs[i]!=0 && djs[i]<min) {
                        min = djs[i];
                        minIdx = i;
                    }
                }
                f[minIdx]=true;
                for(int i=minIdx+1;i<=minIdx+21;i++) {
                    if(map[minIdx][i]!=0) {//我初始化的时候没有把邻接矩阵的初始值赋一个大的数，所以这里要特判一下
                        if(djs[i]==0)djs[i] = djs[minIdx]+map[minIdx][i];
                        else{
                            if(djs[minIdx]+map[minIdx][i]<djs[i])djs[i]=djs[minIdx]+map[minIdx][i];
                        }
                    }
                }
            }
            System.out.println(djs[2021]);

        }
        public static int gcd(int x,int y) {//欧几里得算法
            return x%y!=0 ? gcd(y, x % y) : y;
        }

        public static int lcm(int x,int y) {//最小公倍数
            return x * y / gcd(x, y);
        }
    }