/*
* 小蓝有很多数字卡片，每张卡片上都是数字 0 到 9。
* 小蓝准备用这些卡片来拼一些数，他想从 1开始拼出正整数，
* 每拼一个， 就保存起来，卡片就不能用来拼其它数了。 小蓝想知道
* 自己能从 1 拼到多少。 例如，当小蓝有 30 张卡片，其中
* 0 到 9各 3张，则小蓝可以拼出 1到 10， 但是拼 10
* 时卡片 1 已经只有一张了，不够拼出 11。 现在小蓝手里有 0到 9 的卡
* 片各 2021 张，共 20210 张，请问小蓝可以从 1拼到多少？
* 提示：建议使用计算机编程解决问题*/
public class Lqkp {

    public static int arr[]=new int[10];

    public static void main(String[] args) {
        for(int i=0;i<=9;i++)
            arr[i]=2021;
        for(int i=1;;i++){
            if(!isuse(i)) {
                System.out.println(i - 1);
                break;
            }
        }
    }
    public static boolean isuse(int k){
        while(k!=0){
            arr[k%10]--;
            if(arr[k%10]<0)
                return false;
            k/=10;
        }
        return true;
    }
    }
