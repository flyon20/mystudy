//冒泡排序
public class MyArray3 {

    public void sort(Student [] stu) {
        for(int i = 0;i<stu.length-1;i++)
            for(int j =0;j<stu.length-1-i;j++) {
                if(stu[j].score>stu[j+1].score) {
                    Student t=stu[j];//注意交换的是数组值而不是单独的成绩值
                    stu[j]=stu[j+1];
                    stu[j+1]=t;
                }

            }

    }

}
