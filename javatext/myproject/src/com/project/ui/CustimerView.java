package com.project.ui;

import com.project.bean.Customer;
import com.project.service.CustomerList;
import com.project.util.CMUtility;
import com.sun.jndi.cosnaming.CNCtx;

public class CustimerView {
    private CustomerList customerList = new CustomerList(10);

    public CustimerView(){
        Customer customer = new Customer("王路飞", '男', 23, "13012342134",
                "luzi@hzw.com");
        customerList.addCustomer(customer);
    }
    //显示界面
    private void enterMainMenu(){
        boolean isFlag = true;
        while (isFlag) {
            System.out
                    .println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");

            char menu = CMUtility.readMenuSelection();
            switch (menu){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifuCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.println("确认是否退出（Y/N）");
                    char isExit=CMUtility.readConfirmSelection();
                    if(isExit=='Y'){
                        isFlag=false;
                    }
            }
        }
    }
    //添加客户
    private  void addNewCustomer(){
        System.out.println("---------------------添加客户---------------------");
        System.out.println("姓名：");
        String name = CMUtility.readString(10);

        System.out.println("性别：");
        char gender = CMUtility.readChar();

        System.out.println("年龄：");
        int age = CMUtility.readInt();

        System.out.println("电话：");
         String phone = CMUtility.readString(13);

         System.out.println("邮箱：");
        String email = CMUtility.readString(30);

        //封装数据
        Customer customer = new Customer(name,gender,age,phone,email);
        boolean isSucces = customerList.addCustomer(customer);
        if(isSucces){
            System.out.println("---------------------添加完成---------------------");
        }else {
            System.out.println("---------------------客户已满---------------------");
        }

    }
    //修改客户
    private void modifuCustomer(){
        System.out.println("---------------------修改客户---------------------");
        Customer cust;
        int number;
        for(;;) {
            System.out.println("请选择正确的编号（-1退出）");
             number= CMUtility.readInt();
            if(number==-1){
                return;
            }
            cust = customerList.getCustomer(number -1);
            if(cust==null){
                System.out.println("无法找到指定客户");
            }else{
                break;
            }
        }

        System.out.println("姓名（"+cust.getName()+")");
        String name = CMUtility.readString(10,cust.getName());
        System.out.println("性别（"+cust.getGender()+")");
        char gender = CMUtility.readChar(cust.getGender());
        System.out.println("年龄（"+cust.getAge()+")");
        int age = CMUtility.readInt(cust.getAge());
        System.out.println("电话（"+cust.getPhone()+")");
        String phone = CMUtility.readString(13,cust.getPhone());
        System.out.println("邮箱（"+cust.getEmail()+")");
        String email = CMUtility.readString(30,cust.getEmail());

        Customer newcust = new Customer(name,gender,age,phone,email);
       boolean isRepalaced =  customerList.replaceCustomer(number-1,newcust);
        if(isRepalaced){
            System.out.println("----------------------修改完成--------------------");
        }else {
            System.out.println("----------------------修改失败--------------------");
        }

    }
    //删除客户
    private void deleteCustomer(){
        System.out.println("--------------------删除客户----------------------");
        Customer cust;
        int number;
        for(;;) {
            System.out.println("选择待删除编号（-1退出）");
            number = CMUtility.readInt();

            if(number==-1.){
                return;
            }
            cust = customerList.getCustomer(number -1);
            if(cust==null){
                System.out.println("无法找到指定客户");
            }else{
                break;
            }
        }
        System.out.println("是否确认删除（Y/N）");
        char isDelete = CMUtility.readChar();
        if (isDelete=='Y'){
            boolean deleste = customerList.deleteCustomer(number-1);
            if(deleste){
                System.out.println("--------------------删除成功----------------------");
            }else{
                System.out.println("--------------------删除失败----------------------");
            }
        }



    }
    //显示客户列表
    private void listAllCustomer(){
        System.out.println("---------------------客户列表---------------------");

        int total = customerList.getTotal();
        if(total==0){
            System.out.println("没有客户记录");
        }else {
            System.out.println("编号\t姓名\t\t性别\t年龄\t电话\t\t\t\t邮箱");
            Customer[] custs = customerList.getAllCustomer();
            for(int i=0;i < custs.length;i++){
                Customer cust=custs[i];
                System.out.println((i+1)+"\t"+cust.getName()+" \t"+cust.getGender()+" \t"
                        +cust.getAge()+" \t"+cust.getPhone()+" \t"+cust.getEmail()+" \t");
            }

        }




        System.out.println("---------------------客户列表完成---------------------/n");
    }

    public static void main(String[] args) {
        CustimerView view = new CustimerView();
        view.enterMainMenu();
    }


}
