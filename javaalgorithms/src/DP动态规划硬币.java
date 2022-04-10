import java.util.Scanner;

public class DP动态规划硬币 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int []dp = new int[999];
        int cost = 99999;
        for(int i=1;i<=n;i++){
            if(i-1>=0)
                cost=Math.min(cost,dp[i-1]+1);
            if(i-5>=0)
                cost=Math.min(cost,dp[i-5]+1);
            if(i-11>=0)
                cost=Math.min(cost,dp[i-11]+1);
            dp[i]=cost;
        }
        System.out.println(dp[n]);


    }
}
