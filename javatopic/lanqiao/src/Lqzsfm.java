/*
* */
import java.util.Scanner;
public class Lqzsfm {

// 1:无需package
// 2: 类名必须Main, 不可修改


        public static void main(String[] args) {
            new Lqzsfm().run();
        }

        void run() {
            long N = new Scanner(System.in).nextLong(), ans = 1;
            for (long pow3 = 1; pow3 < N; pow3 = pow3 * 3 + 1, ans++);
            System.out.println(ans);
        }
    }
