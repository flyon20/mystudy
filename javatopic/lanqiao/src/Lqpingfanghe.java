/*平方和
* 小明对数位中含有 2、0、1、92、0、1、9 的数字很感兴趣，在 11 到 4040 中这样的数包括 1、2、9、101、2、9、10
* 至 32、3932、39 和 4040，共 2828 个，他们的和是 574574，平方和是 1436214362。

注意，平方和是指将每个数分别平方后求和。

请问，在 11 到 20192019 中，所有这样的数的平方和是多少？*/
import java.util.Scanner;

public class Lqpingfanghe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        Long sum = 0L;
        int n=scan.nextInt();
        for(int i=1;i<=n;i++) {
            if (t(i))
                sum+=i*i;
        }

        System.out.println(sum);

    }
    private static boolean t(int x) {
        int i;
        while(x!=0) {
            i=x%10;
            if(i==0||i==1||i==2||i==9)
                return true;
            x=x/10;
        }
        return  false;
    }
}
