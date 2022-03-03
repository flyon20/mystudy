/*
* 小蓝要用七段码数码管来表示一种特殊的文字。
上图给出了七段码数码管的一个图示，数码管中一共有 77 段可以发光的二 极管，分别标记为 a, b, c, d, e, f, ga,b,c,d,e,f,g。
小蓝要选择一部分二极管（至少要有一个）发光来表达字符。在设计字符 的表达时，要求所有发光的二极管是连成一片的。
例如：bb 发光，其他二极管不发光可以用来表达一种字符。
例如 cc 发光，其他二极管不发光可以用来表达一种字符。这种方案与上 一行的方案可以用来表示不同的字符，尽管看上去比较相似。
例如：a, b, c, d, ea,b,c,d,e 发光，f, gf,g 不发光可以用来表达一种字符。
例如：b, fb,f 发光，其他二极管不发光则不能用来表达一种字符，因为发光 的二极管没有连成一片。
请问，小蓝可以用七段码数码管表达多少种不同的字符？*/
import java.util.*;
public class Lqqiduanma {
        private static int ans;
        private static int[][] matrix=new int[7][7];
        private static int[] flash=new int[7];  //亮不亮
        private static int[] visted=new int[7]; //有没有被访问
        public static void main(String[] args) {
            //用图存储七段码
            matrix[0][1]=matrix[1][0]=1;
            matrix[0][5]=matrix[5][0]=1;
            matrix[5][6]=matrix[6][5]=1;
            matrix[6][1]=matrix[1][6]=1;
            matrix[5][4]=matrix[4][5]=1;
            matrix[4][6]=matrix[6][4]=1;
            matrix[6][2]=matrix[2][6]=1;
            matrix[1][2]=matrix[2][1]=1;
            matrix[4][3]=matrix[3][4]=1;
            matrix[2][3]=matrix[3][2]=1;
            //用i的二进制位上的0和1表示对应位置的灯亮或不亮（0<=i<=2的七次方）
            for (int i=0;i<(1<<7);i++){
                //依次遍历2的七次方种情况，检查对应情况下的图是否连通
                if(check(i)){
                    ans++;
                }
            }
            System.out.println(ans);
        }
        public static boolean check(int x){
            for (int i = 0; i <= 6; i++) {
                flash[i] = visted[i] = 0;
            }
            //根据x点亮对应的灯
            for (int i = 0; i <=6; i++) {
                if(((x>>i)&1)!=0){
                    flash[i]=1;
                }
            }
            //
            int count=0;
            for (int i = 0; i <=6; i++) {
                if(flash[i]==1&&visted[i]==0){
                    bfs(i);
                    count++;
                }
            }
            return count==1;
        }
        //广度优先遍历(只会试图去遍历点亮的点)
        public static void bfs(int i){
            LinkedList<Integer> que=new LinkedList<>();
            que.offer(i);
            visted[i]=1;
            while(!que.isEmpty()){
                int u=que.peek();
                que.poll();
                for (int j = 0; j <=6 ; j++) {
                    if(matrix[u][j]!=0&&flash[j]==1&&visted[j]==0){
                        visted[j]=1;
                        que.offer(j);
                    }
                }
            }
        }
    }