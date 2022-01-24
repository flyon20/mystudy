public class Lqnianhaozifuchuan {
    public static void main(String[] args) {
        //	定义用于存储计算结果的arr数组
        char [] arr=new char[100];
        //	定义无符号整形变量的年号
        int year = 2019;
        //输入一个年号
        //	定义用于记录循环次数和结果个数的变量j
        int j = -1;
        //	year大于26时进行循环计算
        while(year>0) {
            //判断year是否为26的倍数
            if(year % 26 != 0){
                //	将年份对26取余 计算结果存入arr数组  例如 'A' + (17 - 1) = Q  第17个字母为Q
                arr[++j] = (char) ('A' + (year % 26 - 1));
                year = year / 26;
            }else {
                arr[++j] = 'A' + 26 - 1;
                year = year / 26 - 1;
            }
        }
        //逆序输出arr
        while(j>=0) {
            System.out.print(arr[j--]);
        }

    }
}
