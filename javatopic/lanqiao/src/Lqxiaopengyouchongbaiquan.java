import java.util.Scanner;

public class Lqxiaopengyouchongbaiquan {
    static int n,cnt,ans;
    static int [] a=new int [100005];
    public static void dfs(int x,int ll,int cnt){
        if(cnt>n)return; //如果所有小朋友都搜索了，返回
        if(x==ll){ //如果搜到了第一个传进来的小朋友，这个有向连通图就全部找完了
            ans=Math.max(ans,cnt); //更新答案
            return; //记得一定return，不然死循环（虽然第一个return已经阻止了死循环，但答案肯定是错的）
        }
        dfs(a[x],ll,cnt+1); //搜索当前小朋友的崇拜对象
    }

    public static void main(String[] args)
        {
        Scanner scan =new Scanner(System.in);
        int n = scan.nextInt();
        for(int i=1;i<=n;i++){
            a[i]=scan.nextInt();
        }
        for(int i=1;i<=n;i++){
            dfs(a[i],i,1); //搜索每个小朋友崇拜的对象，并传入这个小朋友的编号
        }
        System.out.println(ans);;

    }
}