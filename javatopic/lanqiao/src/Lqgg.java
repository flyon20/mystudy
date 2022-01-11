/*
* 灌溉
* 问题描述
　　小蓝负责花园的灌溉工作。
　　花园可以看成一个 n 行 m 列的方格图形。中间有一部分位置上安装有出水管。
　　小蓝可以控制一个按钮同时打开所有的出水管，打开时，有出水管的位置可以被认为已经灌溉好。
　　每经过一分钟，水就会向四面扩展一个方格，被扩展到的方格可以被认为已经灌溉好。即如果前一分钟某一个方格被灌溉好，则下一分钟它上下左右的四个方格也被灌溉好。
　　给定花园水管的位置，请问 k 分钟后，有多少个方格被灌溉好？
输入格式
　　输入的第一行包含两个整数 n, m。
　　第二行包含一个整数 t，表示出水管的数量。
　　接下来 t 行描述出水管的位置，其中第 i 行包含两个数 r, c 表示第 r 行第 c 列有一个排水管。
　　接下来一行包含一个整数 k。
输出格式
　　输出一个整数，表示答案。
样例输入
3 6
2
2 2
3 4
1
样例输出
9
样例说明
　　用1表示灌溉到，0表示未灌溉到。
　　打开水管时：
　　000000
　　010000
　　000100
　　1分钟后：
　　010000
　　111100
　　011110
　　共有9个方格被灌溉好。
数据规模和约定
　　对于所有评测用例，1 <= n, m <= 100, 1 <= t <= 10, 1 <= k <= 100。
*/
import java.util.Scanner;
public class Lqgg {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int a[][] = new int[105][105];
            int b[][] = new int[105][105];
            int count = 0;

            int n = scan.nextInt();
            int m = scan.nextInt();
            int t = scan.nextInt();

            for (int i = 0; i < t; i++) {
                int x = scan.nextInt();
                int y = scan.nextInt();
                a[x][y] = 1;
                b[x][y] = 1;
            }
            int k = scan.nextInt();

            while (k-- > 0) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (a[i][j] == 1) {
                            b[i - 1][j] = 1;
                            b[i][j - 1] = 1;
                            b[i][j + 1] = 1;
                            b[i + 1][j] = 1;
                        }
                    }
                }
                for (int i = 1; i <= n; i++) {
                    a[i] = b[i].clone();
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (b[i][j] == 1) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
