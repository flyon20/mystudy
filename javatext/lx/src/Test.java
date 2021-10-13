import java.util.Scanner;

    public class Test {

        public static void main(String[] args) {
            Student [] stu = new Student[20];
            int state=0;
//		System.out.println("请输入指定查询年级数");
//		Scanner get=new Scanner(System.in);
//		state=get.nextInt();

            MyArray1 test =new MyArray1();
            test.get(stu);//赋值

            MyArray2 test1 =new MyArray2();
            test1.person(stu);
            System.out.println("====================");

            System.out.println("请输入指定查询年级数");
            Scanner get=new Scanner(System.in);
            state=get.nextInt();
            System.out.println(state+"年级的信息");
            MyArray4 test2=new MyArray4();//指定年级的信息
            test2.print(stu,state);
            System.out.println("\n====================");

            System.out.println("\n冒泡排序后");
            MyArray3 test3=new MyArray3();//排序
            test3.sort(stu);
            test1.person(stu);//遍历

        }

    }

    class Student{
        int number;//学号
        int state;//年级
        int score;//成绩
    }

