import java.util.Scanner;

/*考虑一种简单的正则表达式：
只由 x ( ) | 组成的正则表达式。
小明想求出这个正则表达式能接受的最长字符串的长度。
例如 ((xx|xxx)x|(x|xx))xx 能接受的最长字符串是： xxxxxx，长度是 6。*/
public class Lq正则问题 {
    static int i=0;
    static String str;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        str = scan.next();
        System.out.println(dfs());
    }
    public static int dfs(){
        int xnum=0,maxx=0;
        while(i<str.length()){
            if(str.charAt(i)=='('){
                i++;
                xnum+=dfs();
            }
            else if(str.charAt(i)=='x'){
                i++;
                xnum++;
            }
            else if(str.charAt(i)=='|'){
                i++;
                maxx=Math.max(xnum,maxx);
                xnum=0;
            }
            else {
                i++;
                break;
            }
        }
        return Math.max(xnum,maxx);
    }
}
