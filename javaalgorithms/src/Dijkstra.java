import java.util.HashSet;
import java.util.Set;

public class Dijkstra {



        private static final int INF = Integer.MAX_VALUE - 10000000;

        static int[] func(int[][] matrix) {

            if (matrix[0].length != matrix.length) throw new IllegalArgumentException("对接矩阵不是方阵");
            int[] dis = matrix[0];
            Set<Integer> set = new HashSet<>();

            while (set.size() != matrix.length) {

                /* 通过for循环得到 min & minIndex */
                int min = INF;
                int minIndex = 0;

                for (int i = 0; i < matrix.length; i++) {

                    if (dis[i] < 0) throw new IllegalArgumentException("对接矩阵中存在负数");

                    if (((!set.contains(i)) && (dis[i] != 0) && (dis[i] <= min))) {
                        min = dis[i];
                        minIndex = i;
                    }

                }

                /* 进行松弛操作 */
                if (!set.add(minIndex)) throw new IllegalArgumentException();
                int[] arr = matrix[minIndex];

                for (int i = 0; i < matrix.length; i++) {

                    if (arr[i] < 0) throw new IllegalArgumentException("对接矩阵中存在负数");

                    if (arr[i] != INF && arr[i] != 0) {
                        if ((dis[minIndex] + arr[i]) < dis[i]) dis[i] = dis[minIndex] + arr[i];
                    }

                }

            }

            return dis;

        }

        public static void main(String[] args) {

            int[][] m1 = new int[][]{
                    {0, INF, 10, INF, 30, 100},
                    {INF, 0, 5, INF, INF, INF},
                    {INF, INF, 0, 50, INF, INF},
                    {INF, INF, INF, 0, INF, 10},
                    {INF, INF, INF, 20, 0, 60},
                    {INF, INF, INF, INF, INF, 0}
            };

            int[][] m2 = new int[][]{
                    {0,1,12,INF,INF,INF},
                    {INF,0,9,3,INF,INF},
                    {INF,INF,0,INF,5,INF},
                    {4,0,13,15,INF,INF},
                    {INF,INF,INF,INF,0,4},
                    {INF,INF,INF,INF,INF,0}
            };

            int[] arr1 = func(m1);

            for (int num : arr1) {
                if (num == INF) System.out.print("inf");
                else System.out.print(num);
                System.out.print(" ");
            }

            int[] arr2 = func(m2);

            for (int num : arr2) {
                if (num == INF) System.out.print("inf");
                else System.out.print(num);
                System.out.print(" ");
            }

        }

    }
