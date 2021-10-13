package view;

import domain.*;

import service.*;


public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public TeamView() {
    }

    public void enterMainMenu() {
        boolean loopFlag = true;
        char key = 0;

        do {
            if (key != '1') {
                this.listAllEmployees();
            }

            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
            key = TSUtility.readMenuSelection();
            System.out.println();
            switch(key) {
                case '1':
                    this.listTeam();
                    break;
                case '2':
                    this.addMember();
                    break;
                case '3':
                    this.deleteMember();
                    break;
                case '4':
                    System.out.print("确认是否退出(Y/N)：");
                    char yn = TSUtility.readConfirmSelection();
                    if (yn == 'Y') {
                        loopFlag = false;
                    }
            }
        } while(loopFlag);

    }

    private void listAllEmployees() {
        System.out.println("\n-------------------------------开发团队调度软件--------------------------------\n");
        Employee[] emps = this.listSvc.getAllEmployees();
        if (emps.length == 0) {
            System.out.println("没有客户记录！");
        } else {
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
        }

        Employee[] var5 = emps;
        int var4 = emps.length;

        for(int var3 = 0; var3 < var4; ++var3) {
            Employee e = var5[var3];
            System.out.println(" " + e);
        }

        System.out.println("-------------------------------------------------------------------------------");
    }

    private void listTeam() {
        System.out.println("\n--------------------团队成员列表---------------------\n");
        Programmer[] team = this.teamSvc.getTeam();
        if (team.length == 0) {
            System.out.println("开发团队目前没有成员！");
        } else {
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
        }

        Programmer[] var5 = team;
        int var4 = team.length;

        for(int var3 = 0; var3 < var4; ++var3) {
            Programmer p = var5[var3];
            System.out.println(" " + p.getDetailsForTeam());
        }

        System.out.println("-----------------------------------------------------");
    }

    private void addMember() {
        System.out.println("---------------------添加成员---------------------");
        System.out.print("请输入要添加的员工ID：");
        int id = TSUtility.readInt();

        try {
            Employee e = this.listSvc.getEmployee(id);
            this.teamSvc.addMember(e);
            System.out.println("添加成功");
        } catch (TeamException var3) {
            System.out.println("添加失败，原因：" + var3.getMessage());
        }

        TSUtility.readReturn();
    }

    private void deleteMember() {
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
