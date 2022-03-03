/*
* 你一定听说过这个故事。国王对发明国际象棋的大臣很佩服，问他要什么报酬，
* 大臣说：请在第 11 个棋盘格放 11 粒麦子，在第 22 个棋盘格放 22 粒麦子，
* 在第 33 个棋盘格放 44 粒麦子，在第 44 个棋盘格放 88 粒麦子，......
* 后一格的数字是前一格的两倍，直到放完所有棋盘格（国际象棋共有 6464 格）。
国王以为他只是想要一袋麦子而已，哈哈大笑。
当时的条件下无法准确计算，但估算结果令人吃惊：即使全世界都铺满麦子也不够用！
请你借助计算机准确地计算，到底需要多少粒麦子。*/
import java.math.BigInteger;
public class Lqqipanfangmaizi {
    public static void main(String[] args) {
        BigInteger sum = new BigInteger("0");
        BigInteger js  = new BigInteger("2");
        for(int i=0;i<64;i++){
            BigInteger mz = js.pow(i);
            sum=sum.add(mz);
        }
        System.out.println(sum);

    }
}
