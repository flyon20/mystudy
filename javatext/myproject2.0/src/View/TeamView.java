package View;

import domain.Employee;
import domain.Programmer;
import service.NameListService;
import service.TeamException;
import service.TeamService;

public class TeamView {

    private NameListService listSvc = new NameListService();
    private TeamService teamSvc=new TeamService();
    char menu=0;
    public void enterMainMenu(){
        boolean loopFlag=true;
        while (loopFlag){
            if(menu!='1'){
            listAllEmployees();
            }
            System.out.println("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");

            menu = TSUtility.readMenuSelection();
            switch (menu){
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("确认是否退出（Y/N）");
                    char isExit=TSUtility.readConfirmSelection();
                    if(isExit=='Y'){
                        loopFlag = false;
                    }
                    break;

            }

        }

    }

    private void listAllEmployees(){
        System.out.println("\n-------------------------------开发团队调度软件--------------------------------\n");
        Employee[] employees=listSvc.getAllEmpioyees();
        if(employees==null ||employees.length==0){
            System.out.println("没有任何员工信息");
        }else{
            System.out.println("ID\t姓名\t\t年龄\t工资\t\t职位\t\t状态\t\t奖金\t股票\t\t领用设备");
            for(int i = 0;i< employees.length;i++){
                System.out.println(employees[i]);
            }
        }
        System.out.println("-------------------------------------------------------------------------------");

    }
    private void getTeam(){
        System.out.println("\n--------------------团队成员列表---------------------\n");
        Programmer[] team=teamSvc.getTeam();
        if(team==null||team.length==0){
            System.out.println("没有成员");
        }else {
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
            for(int i=0;i< team.length;i++){
                System.out.println(team[i].getDetailsForTeam());
            }
        }
        Programmer[] var5 = team;
        int var4 = team.length;
        for(int var3 = 0; var3 < var4; ++var3) {
             Programmer p = var5[var3];
              System.out.println(" " + p.getDetailsForTeam());
        }
        System.out.println("-----------------------------------------------------");
    }
    private void addMember(){
        System.out.println("---------------------添加成员---------------------");
        System.out.println("请输入添加的id");
        int id = TSUtility.readInt();
        try{
            Employee emp = listSvc.getEmployees(id);
            teamSvc.addMember(emp);
            System.out.println("添加成功");
            TSUtility.readReturn();
        }catch (TeamException e){
            System.out.println("添加失败"+e.getMessage());
        }


    }
    private void deleteMember(){
        System.out.println("---------------------删除成员---------------------");
        System.out.print("请输入要删除员工的TID：");
        int id = TSUtility.readInt();
        System.out.print("确认是否删除(Y/N)：");
        char yn = TSUtility.readConfirmSelection();
        if (yn != 'N') {
            try {
                this.teamSvc.removeMember(id);
                System.out.println("删除成功");
            } catch (TeamException var4) {
                System.out.println("删除失败，原因：" + var4.getMessage());
            }

            TSUtility.readReturn();
        }
    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }


}
