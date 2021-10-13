import java.util.Scanner;
//回文数的判断
public class Text {
    public static void main(String[] args) {
        Scanner b = new Scanner(System.in);
       int s=b.nextInt();
//        String  m=String.valueOf(s);

        System.out.println(isHW(s));

    }
    static boolean isHW(int s){
        boolean result = true;
//        int count = s.length();
//
//
//        for(int i=0;i<count/2;i++){
//            char a = s.charAt(i);
//            char b = s.charAt(count-i-1);
//            if(a!=b){
//                return false;
//            }
//        }
//        return result;

        if (s<0 || (s!=0 && s%10==0)) return false;
        int rev = 0;
        while (s>rev){
            rev = rev*10 + s%10;
            s = s/10;
        }
        return (s==rev || s==rev/10);
    }
}
