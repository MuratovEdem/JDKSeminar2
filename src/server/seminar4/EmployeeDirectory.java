package server.seminar4;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory {
    private List<Employee> employees;

    public EmployeeDirectory(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee getEmployeeByExperience(int experience) {
        return employees.stream().filter(e -> e.getExperience() == experience).findFirst().orElse(null);
    }

    public long getPhoneNumberByName(String name) {
        return employees.stream().filter(e -> e.getName().equals(name)).findFirst().get().getPhone();
    }

    public Employee getEmployeeByServiceNumber(int serviceNumber) {
        return employees.stream().filter(e -> e.getServiceNumber() == serviceNumber).findFirst().orElse(null);
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

}
