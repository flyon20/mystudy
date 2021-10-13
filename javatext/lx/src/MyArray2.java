//遍历
public class MyArray2 {

    public void person(Student[] stu) {


        for(int i=0;i<stu.length;i++)
        {
            System.out.println("学号："+stu[i].number+"年级："+stu[i].state+
                    "成绩："+stu[i].score);
            /**
             * 此处容易直接写成输出数组stu这样写会造成输出的值为地址，故需要指出其出堆的值即所赋予的值
             */
        }

    }

}
