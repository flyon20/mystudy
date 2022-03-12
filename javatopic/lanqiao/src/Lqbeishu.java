public class Lqbeishu {
    public static void main(String[] args) {
        int count=0;
        for(int i=0;i<2020;i++){
            if(i%4==0&&i%6==0)
                count++;
        }
        System.out.println(count);
    }
}
