package com.project.service;

import com.project.bean.Customer;

public class CustomerList {
        private Customer[] customers;
        private  int total=0;//记录客户个数
        //初始化customer数组构造器
        public  CustomerList(int totalCustomer){
                customers = new Customer[totalCustomer];
        }
        //将指定客户添加到指定数组
        public  boolean addCustomer(Customer customer){
              if(total >= customers.length){
                      return  false;
              }
              customers[total++]=customer;
              return true;
        }
        //修改指定位置客户信息
        public  boolean replaceCustomer(int index,Customer cust){
                if(index <0 || index >= total){
                        return false;
                }
                customers[index]=cust;
                return  true;
        }
        public boolean deleteCustomer(int index){
                if(index <0 || index >= total){
                        return false;
                }
                for (int i = index;i<total-1;i++){
                        customers[i] = customers[i+1];
                }
//                customers[total - 1]=null;
//                total--;
                customers[--total]=null;
                return true;
        }
        //获取所有客户信息
        public  Customer[] getAllCustomer(){
                Customer[] custs = new Customer[total];
                for(int i=0;i<total;i++){
                        custs [i]=customers[i];
                }
                return custs;
        }
        //获取指定位置客户
        public Customer getCustomer(int index){
                if(index <0 || index >= total){
                        return null;
                }
                return customers[index];
        }
        public  int getTotal(){
                return total;
        }
}
