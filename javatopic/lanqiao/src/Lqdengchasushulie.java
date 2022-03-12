/*2,3,5,7,11,13,.... 是素数序列。 类似：7,37,67,97,127,1577,37,67,97,127,157
这样完全由素数组成的等差数列，叫等差素数数列。
上边的数列公差为 3030，长度为 66。
20042004 年，格林与华人陶哲轩合作证明了：存在任意长度的素数等差数列。
这是数论领域一项惊人的成果！
有这一理论为基础，请你借助手中的计算机，满怀信心地搜索：
长度为 1010 的等差素数列，其公差最小值是多少？*/
public class Lqdengchasushulie {
    public static void main(String[] args) {
        for(int i=1;i<1000;i++) {
            for (int j = 1;j<1000; j++) {
                int k;
                for (k = 0; k < 10; k++) {
                    if (!isPrim(i + k * j))
                        break;
                }
                if (k == 10) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
    public static boolean isPrim(int n){
        for(int i=n-1;i>1;i--) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

}
