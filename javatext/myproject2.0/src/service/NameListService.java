package service;


import domain.*;
import static service.Data.*;

public class NameListService {
    private Employee[] employees;
    public NameListService(){
        this.employees = new Employee[EMPLOYEES.length];

        for(int i=0;i<employees.length;++i){
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            //获取员工基本信息
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name= EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            //Double salary = Double.parseDouble(EMPLOYEES[i][4]);
            double salary = (double)Integer.parseInt(EMPLOYEES[i][4]);

            Equipment  equipment;
            double bouns;
            int stock;
            switch(type) {
                case EMPLOYEE:
                    this.employees [i]= new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER:
                    equipment = createEquipment(i);
                    this.employees [i]= new Programmer(id,name,age,salary,equipment);
                    break;
                case DESIGNER:
                    equipment = createEquipment(i);
                    bouns = Double.parseDouble(EMPLOYEES[i][5]);
                    this.employees [i]= new Designer(id,name,age,salary,equipment,bouns);
                    break;
                case ARCHITECT:
                    equipment = createEquipment(i);
                    bouns = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    this.employees [i]= new Architect(id,name,age,salary,equipment,bouns,stock);
                    break;


            }
        }
    }
   private Equipment createEquipment(int idex){
        int type = Integer.parseInt(EQUIPMENTS[idex][0]);

                String model=EQUIPMENTS[idex][1];
        switch (type){
            case PC:
                String display = EQUIPMENTS[idex][2];
                return new PC(model,display);
            case NOTEBOOK:
                String price = EQUIPMENTS[idex][2];
                return new NoteBook(model,price);
            case PRINTER:
                String typel =EQUIPMENTS[idex][2];
                return new Printer(model,typel);
        }

        return null;
    }
    public Employee getEmployees(int id) throws TeamException {
//        for(int i=0;i<=employees.length;i++){
//            if(employees[i].getId()==id)
//                return employees[i];
//        }
        Employee[] var5;
        int var4 = (var5 = this.employees).length;

        for(int var3 = 0; var3 < var4; ++var3) {
            Employee e = var5[var3];
            if (e.getId() == id) {
                return e;
            }
        }
        throw new TeamException("找不到指定员工");

    }

    public Employee[] getAllEmpioyees(){

        return employees;
    }



}
