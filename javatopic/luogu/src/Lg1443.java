import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Lg1443 {
        // 存储马目前的坐标,和到达所在坐标所需步数
        static Queue<Integer> mx = new LinkedList<Integer>();
        static Queue<Integer> my = new LinkedList<Integer>();
        static Queue<Integer> mStep = new LinkedList<Integer>();
        static int n, m, X, Y, arr[][];// arr存放最终解
        // xx yy 用来存储马儿可以走的8种方法
        static int[] xx = { -1, -1, 1, 1, -2, -2, 2, 2 };
        static int[] yy = { -2, 2, -2, 2, -1, 1, -1, 1 };
        static boolean isVisited[][];// 判断马儿有没有走过相应的位置

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            n = scan.nextInt();
            m = scan.nextInt();
            X = scan.nextInt();
            Y = scan.nextInt();
            arr = new int[n + 1][m + 1];
            isVisited = new boolean[n + 1][m + 1];
            mx.add(X);
            my.add(Y);
            mStep.add(0);// 先将马初始位置放入mx my,并且将0放入mStep
            isVisited[X][Y] = true;// 记得将马一开始所在的位置置为走过,否则会有回跳现象
            bfs();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (!isVisited[i][j]) {
                        System.out.printf("%-5d", -1);
                    } else {
                        System.out.printf("%-5d", arr[i][j]);
                    }
                }
                System.out.println();
            }
        }

        // 广度优先搜索
        public static void bfs() {
            int x, y, step;// 临时变量记录每次的坐标与走到当前所在坐标的步数
            while (!mx.isEmpty()) {// 只要mx不为空,就一直找
                x = mx.poll();// 返回并去掉mx头部的值
                y = my.poll();// 返回并去掉my头部的值
                step = mStep.poll();// 返回并去掉mStep头部的值
                arr[x][y] = step;// 将相应位置的步数记录下来

                for (int i = 0; i < 8; i++) {// 尝试8种走法
                    // 当然要确保走法不能超出范围并且那种走法走到的那一个位置之前没有走过
                    if (x + xx[i] >= 1 && x + xx[i] <= n && y + yy[i] >= 1 && y + yy[i] <= m
                            && !isVisited[x + xx[i]][y + yy[i]]) {
                        // 如果该走法行得通
                        isVisited[x + xx[i]][y + yy[i]] = true;// 那么把该走法走到的这一个位置置为访问过
                        mx.add(x + xx[i]);// 向mx加入该横坐标
                        my.add(y + yy[i]);// 向my加入该纵坐标
                        mStep.add(step+1);// 走到该位置的步数是走到上一位置的步数+1;记住不是++,step不能变,否则在尝试下一种走法的时候步数会变多,实际上每一次while的step都是一样的
                    }
                }
            }
        }
    }
