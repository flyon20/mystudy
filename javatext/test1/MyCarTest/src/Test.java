import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int a[] = new int[13];
        int b = 0, j = 1;

        for (int i = 0; i <= 13; i++) {
            b = (int) (0 + Math.random() * (13 - 0 + 1));
            switch (b) {
                case 0:
                    System.out.println("一、夜间在没有路灯或照明不良条件下行驶（(开远光灯)。");
                    break;
                case 1:
                    System.out.println("二、夜间通过没有交通信号灯路口(远近光灯交替)。");
                    break;
                case 2:
                    System.out.println("三、通过有信号指示灯的路口(开近光灯)。");
                    break;
                case 3:
                    System.out.println("四、路边临时停车(关大灯，保留示廓灯，开应急灯)。");
                    break;
                case 4:
                    System.out.println("五、大雨天行驶(开大灯，雾灯，应急灯，开雨刮器)");
                    break;
                case 5:
                    System.out.println("六、雾天行驶(开大灯，雾灯，应急灯)。");
                    break;
                case 6:
                    System.out.println("七、超车（开左灯3秒后，远近光灯交替，关左灯)。");
                    break;
                case 7:
                    System.out.println("八、夜间通过急弯(远近光灯交替)。");
                    break;
                case 8:
                    System.out.println("九、通过路口左转弯（开大灯，开左灯)。");
                    break;
                case 9:
                    System.out.println("十、夜间通过拱桥（远近光灯交替)。");
                    break;
                case 10:
                    System.out.println("十一、夜间通过人行横道（远近光灯交替)。");
                    break;
                case 11:
                    System.out.println("十二、夜间在有路灯照明良好的道路上行驶(开近光灯)");
                    break;
                case 12:
                    System.out.println("十三、同方向近距离条件下你紧跟前车行驶（(开近光灯)。");
                    break;
                case 13:
                    System.out.println("十四、无路灯照明且对向车道150米内有车辆行驶（开近光灯)。");
                    break;
            }



        }
    }
}
