/*
* 小蓝有很多数字卡片，每张卡片上都是数字 00 到 99。
* 小蓝准备用这些卡片来拼一些数，他想从 11 开始拼出正整数，
* 每拼一个， 就保存起来，卡片就不能用来拼其它数了。 小蓝想知道
* 自己能从 11 拼到多少。 例如，当小蓝有 3030 张卡片，其中
* 00 到 99 各 33 张，则小蓝可以拼出 11 到 1010， 但是拼 1111
* 时卡片 11 已经只有一张了，不够拼出 1111。 现在小蓝手里有 00 到 99 的卡
* 片各 20212021 张，共 2021020210 张，请问小蓝可以从 11 拼到多少？
* 提示：建议使用计算机编程解决问题*/
public class Lqkp {

        public static int arr[]=new int[10];

        public static boolean d(int x){
            while(x!=0){
                arr[x%10]--;
                if(arr[x%10]<0)return false;
                x/=10;
            }
            return true;
        }
        public static void main(String[] args) {

            for(int i=0;i<10;i++)
                arr[i]=2021;

            for(int i=1;i<5000;i++){
                if(!d(i)){
                    System.out.println(i-1);
                    break;
                }
            }
        }
    }
