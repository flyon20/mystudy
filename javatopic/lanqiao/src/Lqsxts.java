/*
* 蛇形填数
本题总分：10 分
【问题描述】
如下图所示，小明用从 1 开始的正整数“蛇形”填充无限大的矩阵。
1 2 6 7 15 …
3 5 8 14 …
4 9 13 …
10 12 …
11 …
…
(1)
容易看出矩阵第二行第二列中的数是 5。请你计算矩阵中第 20 行第 20 列
的数是多少？
*/
public class Lqsxts {
        public static void main(String[] args) {
            int[][] arr = new int[100][100];
            int count = 1 ;
            for(int i = 0 ; i < 100 ; i ++) {
                for(int j = 0 ; j < i + 1 ; j ++) {
                    arr[i-j][j] = count ++;
                }
            }
            System.out.println(arr[19][19]);
        }
    }