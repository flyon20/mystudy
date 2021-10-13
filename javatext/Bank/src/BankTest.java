public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addCustomer("法外狂徒张三","自闭患者李四");

        bank.getCustomer(0).setAccount(new Account(2000));

        bank.getCustomer(0).getAccount().withdraw(500);

        double balance=bank.getCustomer(0).getAccount().getBalance();
        System.out.println("客户"+bank.getCustomer(0).getFirstName()+"账户余额为："+balance);

        System.out.println("********************");
        bank.addCustomer("四","自闭患者李");
        System.out.println("银行客户个数为"+bank.getNumberofCustomer());
    }
}
