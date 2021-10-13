public class Textrespt {
    public static void main(String[] args) {
        //多态测试
//        Texttry t = new Texttry();
//        System.out.println(t.Text1());
//        System.out.println( t.gettexttry());
//       Text2 t2=new Text2();
//        System.out.println(t2.Text1());
//        Text1 te= new Text1();
//        System.out.println(te.Text1());
        int text[] = {88, 67, 54, 62, 46, 29, 46, 85, 94, 66};
        int sum = 0, t = 0, max = text[0], min = text[0], i=0;
        for ( i = 0; i < 10; i++) {
            if (max < text[i])
                max = text[i];
            if (min > text[i])
                min = text[i];
            sum += text[i];
        }
        System.out.println(sum);

            System.out.println(max + "  " + min);
        }

    }


