package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;

public class TeamService {

    private static int counter=1;//memberId赋值使用
    private final int Max_Member=5;//限制成员个数
    private Programmer[] team = new Programmer[Max_Member];
    private int total=0;//记录开发团队的实际人数

    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for(int i = 0 ;i<= team.length;++i){
            team[i]=this.team[i];
        }
            return team;
    }
    //将员工添加到开发团队
    public void addMember(Employee e) throws TeamException {
        if(total>=Max_Member){
            throw new TeamException("成员已满,无法添加");
        }
        else if(!(e instanceof Programmer)){
            throw new TeamException("该成员不是技术开发成员，无法添加！");
        }else {
            Programmer p = (Programmer) e;

            if (isExist(p)) {
                throw new TeamException("该成员已在开发成员中！");
            }

//            if ("BUSY".equalsIgnoreCase(p.getStatus().getNAME())) {
//                throw new TeamException("该成员已在开发成员中！");
//            } else if ("VACATION".equalsIgnoreCase(p.getStatus().getNAME())) {
//                throw new TeamException("该成员在休假！");
//            }
            switch (p.getStatus()){
                case BUSY:
                    throw new TeamException("该成员已在开发成员中！");
                case VOCATION:
                    throw new TeamException("该成员在休假！");
            }


            //获取成员中已有架构师，设计师，程序员个数
            int numOfArc = 0, numOfDes = 0, numOfPro = 0;
            for (int i = 0; i < total; i++) {
                if (team[i] instanceof Architect) {
                    ++numOfArc;
                } else if (team[i] instanceof Designer) {
                    ++numOfDes;
                } else if (team[i] instanceof Programmer) {
                    ++numOfPro;
                }
            }

            if (p instanceof Architect) {
                if (numOfArc >= 1) {
                    throw new TeamException("至多只能有一名架构师！");
                }
            }
            if (p instanceof Designer) {
                if (numOfDes >= 2) {
                    throw new TeamException("至多只能有两名设计师！");
                }
            }
            if (p instanceof Programmer) {
                if (numOfPro >= 3) {
                    throw new TeamException("至多只能有三名程序员！");
                }
            }

                p.setStatus(Status.BUSY);
                p.setMemberId(counter++);
                team[total++] = p;

        }
    }

    private boolean isExist(Programmer p) {
        for(int i=0;i<total;i++){
           if(team[i].getId()==p.getId())
            return true;
        }
        return false;
    }


    public void removeMember(int memberId) throws TeamException {
        int i;
        for(i=0;i<total;i++){
            if(team[i].getMemberId()==memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if(i==total){
            throw new TeamException("找不到指定member信息，删除失败！");
        }else {
            //删除替换操作
            for (int j = i + 1; j < total; ++j) {
                team[j - 1] = team[j];
            }

            team[--total] = null;
        }

    }

}
