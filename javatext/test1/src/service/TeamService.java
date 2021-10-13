package service;

import domain.*;

public class TeamService {
    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[5];
    private int total = 0;

    public TeamService() {
    }

    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[this.total];

        for(int i = 0; i < this.total; ++i) {
            team[i] = this.team[i];
        }

        return team;
    }

    public void addMember(Employee e) throws TeamException {
        if (this.total >= 5) {
            throw new TeamException("成员已满，无法添加");
        } else if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        } else {
            Programmer p = (Programmer)e;
            if (this.isExist(p)) {
                throw new TeamException("该员工已在本团队中");
            } else if (p.getStatus().getNAME().equals("BUSY")) {
                throw new TeamException("该员工已是某团队成员");
            } else if (p.getStatus().getNAME().equals("VOCATION")) {
                throw new TeamException("该员正在休假，无法添加");
            } else {
                int numOfArch = 0;
                int numOfDsgn = 0;
                int numOfPrg = 0;

                for(int i = 0; i < this.total; ++i) {
                    if (this.team[i] instanceof Architect) {
                        ++numOfArch;
                    } else if (this.team[i] instanceof Designer) {
                        ++numOfDsgn;
                    } else if (this.team[i] instanceof Programmer) {
                        ++numOfPrg;
                    }
                }

                if (p instanceof Architect) {
                    if (numOfArch >= 1) {
                        throw new TeamException("团队中至多只能有一名架构师");
                    }
                } else if (p instanceof Designer) {
                    if (numOfDsgn >= 2) {
                        throw new TeamException("团队中至多只能有两名设计师");
                    }
                } else if (p instanceof Programmer && numOfPrg >= 3) {
                    throw new TeamException("团队中至多只能有三名程序员");
                }

                p.setStatus(Status.BUSY);
                p.setMemberId(counter++);
                this.team[this.total++] = p;
            }
        }
    }

    private boolean isExist(Programmer p) {
        for(int i = 0; i < this.total; ++i) {
            if (this.team[i].getId() == p.getId()) {
                return true;
            }
        }

        return false;
    }

    public void removeMember(int memberId) throws TeamException {
        int n;
        for(n = 0; n < this.total; ++n) {
            if (this.team[n].getMemberId() == memberId) {
                this.team[n].setStatus(Status.FREE);
                break;
            }
        }

        if (n == this.total) {
            throw new TeamException("找不到该成员，无法删除");
        } else {
            for(int i = n + 1; i < this.total; ++i) {
                this.team[i - 1] = this.team[i];
            }

            this.team[--this.total] = null;
        }
    }
}
