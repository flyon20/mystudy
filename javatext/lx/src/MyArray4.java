//打印三年级学生信息
public class MyArray4 {

    public void print(Student [] stu,int state) {
        for(int i = 0;i<stu.length;i++) {
            if(stu[i].state==state) {
                System.out.println("学号："+stu[i].number+"  年级："+stu[i].state+
                        "  成绩："+stu[i].score);
            }
        }
    }

}
