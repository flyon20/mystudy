package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Equipment;
import domain.NoteBook;
import domain.PC;
import domain.Printer;
import domain.Programmer;

public class NameListService {
    private Employee[] employees;

    public NameListService() {
        this.employees = new Employee[Data.EMPLOYEES.length];

        for(int i = 0; i < this.employees.length; ++i) {
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = (double)Integer.parseInt(Data.EMPLOYEES[i][4]);
            Equipment eq;
            double bonus;
            switch(type) {
                case 10:
                    this.employees[i] = new Employee(id, name, age, salary);
                    break;
                case 11:
                    eq = this.createEquipment(i);
                    this.employees[i] = new Programmer(id, name, age, salary, eq);
                    break;
                case 12:
                    eq = this.createEquipment(i);
                    bonus = (double)Integer.parseInt(Data.EMPLOYEES[i][5]);
                    this.employees[i] = new Designer(id, name, age, salary, eq, bonus);
                    break;
                case 13:
                    eq = this.createEquipment(i);
                    bonus = (double)Integer.parseInt(Data.EMPLOYEES[i][5]);
                    int stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    this.employees[i] = new Architect(id, name, age, salary, eq, bonus, stock);
            }
        }

    }

    private Equipment createEquipment(int index) {
        int type = Integer.parseInt(Data.EQIPMENTS[index][0]);
        switch(type) {
            case 21:
                return new PC(Data.EQIPMENTS[index][1], Data.EQIPMENTS[index][2]);
            case 22:
                int price = Integer.parseInt(Data.EQIPMENTS[index][2]);
                return new NoteBook(Data.EQIPMENTS[index][1], (double)price);
            case 23:
                return new Printer(Data.EQIPMENTS[index][1], Data.EQIPMENTS[index][2]);
            default:
                return null;
        }
    }

    public Employee[] getAllEmployees() {
        return this.employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        Employee[] var5;
        int var4 = (var5 = this.employees).length;

        for(int var3 = 0; var3 < var4; ++var3) {
            Employee e = var5[var3];
            if (e.getId() == id) {
                return e;
            }
        }

        throw new TeamException("该员工不存在");
    }
}
