public class Lqshudefenjie {
    //数的分解
    /*
     * 用2个for循环遍历数字，第3个数字为2019减前两个，要保证一个数比一个大，才能保证不会重。
     * 用一个方法判断每个数都不等于2和4；
     */
        public static void main(String[] args) {
            //个数
            int sum = 0;
            //要保证前面比后面一个数小,0不能包括
            for (int i = 1; i < 2019/2; i++) {
                for (int j = i+1; j < 2019; j++) {
                    int k = 2019-i-j;
                    //要保证不重复，不交换顺序，那么后面的要大于前面的
                    if ((i<j) && (j<k) ) {
                        //判断是否出现2和4
                        if (isF(i) && isF(j) && isF(k) ) {
                            sum++;
                        }
                    }


                }
            }

            System.out.println(sum);

        }
        //判断是不是2和4的方法
        public static boolean isF(int n) {

            int x = n;
            while (true) {
                if (x%10==2 || x%10==4) {
                    return false;
                }
                if (x < 10) {
                    return true;
                }
                x = x/10;
            }

        /*
        String str = n+"";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)=='2' || str.charAt(i)=='4' ) {
                return false;
            }
        }
        return ture;
        */
        }
    }
