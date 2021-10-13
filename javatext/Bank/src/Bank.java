public class Bank {

    private Customer[] customers;
    private  int numberofCustomer;

    public Bank(){
        customers = new Customer[10];
    }
    //添加客户个数
    public void addCustomer(String f,String l){
        Customer cust = new Customer(f,l);
        customers[numberofCustomer++] = cust;
    }
    //获取客户的个数
    public int getNumberofCustomer(){

        return  numberofCustomer;
    }
    //获取指定位置客户
    public Customer getCustomer(int index){
       if(index >=0 && index < numberofCustomer){
           return customers[index];
       }
       return null;
    }
}
