/*小明刚刚看完电影《第 3939 级台阶》，离开电影院的时候，
他数了数礼堂前的台阶数，恰好是 3939 级!
站在台阶前，他突然又想着一个问题：
如果我每一步只能迈上 1 个或 2 个台阶。先迈左脚，然后左右交替，
最后一步是迈右脚，也就是说一共要走偶数步。那么，上完 39级台阶，有多少种不同的上法呢？
请你利用计算机的优势，帮助小明寻找答案。*/
public class Lqdi39jitaijie {
    //过程就是一棵二叉树
    static int sum=0;
    public static void main(String[] args) {
        walk(39,0);
        System.out.println(sum);
    }
    public static void walk(int t,int b){
        if(t<0){
            return ;
        }
        if(t==0&&b%2==0){
            sum++;
        }
        walk(t-1,b+1);
        walk(t-2,b+1);
    }
}
