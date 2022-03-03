public class Lqpfxl {
    public static void main(String[] args) {
        for (int x = 2020; x < 5000; x ++)
            for (int y = x + 1; y < 5000; y ++)
            {
                int t1 = x * x - 2019 * 2019;
                int t2 = y * y - x * x;
                if(t1 == t2)
                {

                    System.out.println(x+y);

                }
            }
    }
}
