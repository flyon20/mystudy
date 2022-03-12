public class Lqpaixu {

        public static void main(String[] args) {
            int arr [] = new int [] {15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
            int sum=0;
            for(int i=0;i<arr.length;i++)
                for(int j=0;j<arr.length-1-i;j++){
                    if(arr[j]>arr[j+1]){
                        int t = arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=t;
                        sum++;
                    }
                }
            System.out.println(sum);

            //思路1:要求字典序最小，那肯定要尽量让字母从a开始挨个出现 —— a,b,c,d.....
            //思路2:冒泡排序中，如果一个数组是完全倒序，则需要的交换的次数最多,尽可能选用完全倒序的数组，可以使字母数尽可能少
            //思路3:完全倒序的数组，用冒泡排序一共要交换 n*(n-1)/2 次 —— (n-1) + (n-2) + ... + 3 + 2 + 1 , 等差数列求和公式
            //思路4:解方程 n*(n-1)/2 = 100, 得 n ~ 14.65 ,所以字母最少为15个
            //思路5: 15个字母从 a 开开始，依次是 a,b,c,d,e,f,g,h,i,j,k,l,m,n,o
            //思路5: 15个字母从 a 开开始，依次是 a,b,c,d,e,f,g,h,i,j,k,l,m,n,o
            //思路5:但是当 n = 15时，完全倒序的数组需要排105次，显然不符合题目100次的要求，所以要在基础上进行修改
            //思路6: 15个字母完全倒序 —— o,n,m,l,k,j,i,h,g,f,e,d,c,b,a 扣除5次排序，只需将第六个字母 j 移至第一位即可
            //最终结果:j,o,n,m,l,k,i,h,g,f,e,d,c,b,a

//            System.out.println("jonmlkihgfedcba");

            //还不理解可以看看下面的代码。
            //15个数字的数组完全倒叙，用冒牌排序的每一次排序的过程，一共输出105次，扣除5次后，找到对应的输出，装换位对应的字母，就是结果
        /*
        int [] arr = {15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};

        int sum = 0;//记录交换次数

        for ( int i = 0 ; i < arr.length - 1  ; i++ ){
            for ( int j = 0 ; j < arr.length - i -1 ; j++ ){

                for( int k = 0 ; k < arr.length ; k++ ){
                    System.out.print(arr[k] + ",");
                }

                if ( arr[j+1] < arr[j] ){
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                    sum++;
                }

                System.out.println("\n");
            }
        }
        System.out.println(sum);
        */
        }
    }
