/*题目描述
在一个 nn 行 mm 列的方格图上有一些位置有地雷，另外一些位置为空。
请为每个空位置标一个整数，表示周围八个相邻的方格中有多少个地雷。
输入描述
输入的第一行包含两个整数 n, mn,m。
第 22 行到第 n + 1n+1 行每行包含 mm 个整数，相邻整数之间用一个空格分隔。如果对应的整数为 00，表示这一格没有地雷。如果对应的整数为 11，表示这一格有地雷。
其中，1 \leq n, m \leq 1001≤n,m≤100 分钟后还是在当天。
输出描述
输出 nn 行，每行 mm 个整数，相邻整数之间用空格分隔。
对于没有地雷的方格，输出这格周围的地雷数量。对于有地雷的方格，输出 99。*/
import java.util.Scanner;
public class Lqsl {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int map[][]=new int[n+2][m+2];
        int result[][]=new int[n+2][m+2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                map[i][j]=sc.nextInt();
            }
        }
        int sum=0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(map[i][j]==1)
                    result[i][j]=9;  //存在地雷赋给9
                else {
                    sum=map[i][j]+map[i-1][j-1]+map[i-1][j]+map[i-1][j+1]+
                            map[i][j-1]+map[i][j+1]+map[i+1][j-1]+map[i+1][j]+map[i+1][j+1];
                    result[i][j]=sum;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

}


