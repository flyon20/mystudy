public class Lqsuanshi900 {
    static int [] flag = new int [10];  // 标记 10 个数字是否被使用过
    static int [] arr = new int [10];;	  // 存储 10 个满足题目意思的书

    public static void Dfs(int n)	  // 深搜思想
    {
        if (n == 10)  // 已经找到 10 个不重复的数
        {
            // 判断是否满足题目的意思  == 900
            if (((arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3]) -
                    (arr[4] * 1000 + arr[5] * 100 + arr[6] * 10 + arr[7])) *
                    (arr[8] * 10 + arr[9]) == 900)
            {
                System.out.println(" ( "+(arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3])+" - "+
                        (arr[4] * 1000 + arr[5] * 100 + arr[6] * 10 + arr[7])+ " ) "+" * "+ (arr[8] * 10 + arr[9])+
                        " = "+900);
            }

            return;		// 不要忘记了这个返回
        }

        for (int i = 0; i < 10; ++i)	// 每一个数都有 10 种可能
        {
            if (i == 0 && (n == 0 || n == 4 || n == 8))	// 个别的数只有 9 种可能  开头没有 0 的情况
                continue;

            if (flag[i] == 0)		// 这个数字当前没有被使用过
            {
                flag[i] = 1;		// 标记为使用过
                arr[n] = i;			// 将这个数存入数组之中
                Dfs(n + 1);			// 下一个位置的深搜
                flag[i] = 0;		// 这个数没有用，取消标记（便于下个位置使用）
            }
        }
    }

    public static void main(String[] args) {
        Dfs(0);
    }
}
