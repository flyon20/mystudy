/*
* 两个字母之间的距离定义为它们在字母表中位置的距离。例如 AA 和 CC 的距离为 22，LL 和 QQ 的距离为 55。

对于一个字符串，我们称字符串中两两字符之间的距离之和为字符串的内部距离。

例如：ZOO 的内部距离为 2222，其中 ZZ 和 OO 的距离为 1111。

请问，LANQIAO 的内部距离是多少？*/
import java.util.Scanner;
public class Lqjlh {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        String s=scan.nextLine();
        int sum=0;
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                sum+=Math.abs((int)s.charAt(i)-(int)s.charAt(j));
            }
        }
        System.out.print(sum);
    }
}
