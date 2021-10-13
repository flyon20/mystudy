public class Arr {

        public static void main(String[] args) {
            int text[] = {88, 67, 54, 62, 46, 29, 46, 85, 94, 66};
            int i = 0, t = 0;
            //逆序
            for ( i = 0; i < text.length / 2; i++) {
                t= text[i];
                text[i] = text[text.length - i -1];
               text[text.length- i -1] = t;
            }
            //冒泡
//            for(i = 0;i<text.length;i++)
//                for(int j =0;j<text.length-1-i;j++) {
//                    if(text[j]>text[j+1]) {
//                       t=text[j];
//                        text[j]=text[j+1];
//                        text[j+1]=t;
//                    }
//
//                }
//选择
////            for (i = 0; i < text.length; i++) {
////                for(int j=i+1;j<text.length;j++){
////                    if(text[i]>text[j]) {
////                        t = text[i];
////                        text[i] = text[j];
////                        text[j] = t;
////                    }
////                }
////            }
//                for (i = 0; i < 10; i++) {
//                    System.out.println(text[i]);
//                }
                for(int a : text){
                    System.out.println(a+"\t");
                }

        }
//public static void main(String[] args) {
//    int []arr= {3,2,8,4,7};//创建数组
//    System.out.println("排序前");
//    showArr(arr);//打印显示排序前
//    //循环实现冒泡排序
//    for(int i=0;i<arr.length-1;i++) {
//        for(int j=0;j<arr.length-i-1;j++) {
//            if(arr[j]>arr[j+1]) {
//                int temp=arr[j];
//                arr[j]=arr[j+1];
//                arr[j+1]=temp;
//            }
//
//        }
//    }
//    System.out.println("排序后");
//    showArr(arr);
//}
//    //打印方法
//    private static void showArr(int []arr) {
//        //增强for循环打印
//        for(int a:arr) {
//            System.out.print(a+"\t");
//
//        }
//        System.out.println();
//
//    }

        }




