/*
* 我们知道第一个质数是 22、第二个质数是 33、第三个质数是 55……

请你计算第 20192019 个质数是多少？*/
public class Lqzhishu {
    public static void main(String[] args) {
        //在此输入您的代码...
        int count=0;
        for(int i=2;;i++){
            for(int j=2;j<=i;j++){
                if(i==j){
                    count++;
                }
                if(i%j==0){
                    break;
                }
            }
            if(count==2019){
                System.out.print(i);
                break;
            }
        }
    }
}
