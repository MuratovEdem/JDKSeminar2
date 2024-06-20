package server.seminar4;

public class Employee {
    private String name;
    private int experience;
    private int serviceNumber;
    private long phone;

    public Employee(String name, int experience, int serviceNumber, long phone) {
        this.name = name;
        this.experience = experience;
        this.serviceNumber = serviceNumber;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public int getServiceNumber() {
        return serviceNumber;
    }

    public long getPhone() {
        return phone;
    }
}
