//赋值
public class MyArray1 {

    public void get(Student [] stu) {
        for(int i = 0;i<stu.length;i++)
        {
            stu[i] = new Student();
            stu[i].number = i+1;
            stu[i].state = (int) (Math.random()*(6-1+1)+1);//随机生成[1.6]的数字
            stu[i].score = (int) (Math.random()*(100-0+1)); //随机生成[0.100]
        }

    }

}
