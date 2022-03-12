import java.util.Scanner;

/*有一个 n×n 的国际象棋棋盘（n 行 n 列的方格图），
请在棋盘中摆放 n个受伤的国际象棋皇后，要求：
任何两个皇后不在同一行。
任何两个皇后不在同一列。
如果两个皇后在同一条 45 度角的斜线上，这两个皇后之间行号的差值至少为 3 。
请问一共有多少种摆放方案。*/
public class Lqshoushangdehuanghou {
    static int result = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int [] queen = new int [a];
        isGet(queen,0,a);
        System.out.println(result);
    }
    public static void isGet(int x[],int i,int n){
        if(i>=n)
            result++;
        else{
            for(int j=0;j < n;j++){
                x[i]=j;
                if(istrue(x,i))
                    isGet(x,i+1,n);
            }
        }
    }
    public static boolean istrue(int x[],int s){
        for(int i=0;i<s;i++){
            if((x[i]==x[s])||(Math.abs(i-s)==Math.abs(x[i]-x[s])))
                return false;
        }
        return true;
    }
    }
