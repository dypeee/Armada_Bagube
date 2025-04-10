class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("Introducing Person:");
        System.out.print("Name: " + name);
        System.out.println(" Age: " + age);
    }
}

class Employee extends Person {
    String jobTitle;

    Employee(String jobTitle, String name, int age) {
        super(name, age);
        this.jobTitle = jobTitle;
    }

    @Override
    public void introduce() {
        System.out.println("Introducing Employee:");
        System.out.print("Name: " + name);
        System.out.print(" Age: " + age);
        System.out.println(" Job Title: " + jobTitle);
    }

}

class Manager extends Employee {
    String department;

    Manager(String name, int age, String jobTitle, String department) {
        super(jobTitle, name, age);
        this.department = department;
    }

    @Override
    public void introduce() {
        System.out.println("Introducing Manager:");
        System.out.print("Name: " + name);
        System.out.print(" Age: " + age);
        System.out.print(" Job Title: " + jobTitle);
        System.out.println(" Department: " + department);
    }
}

public class employeeManagement {
    public static void main(String[] args) {
        Person person = new Person("Daniel", 22);
        Employee employee = new Employee("Software Engineer", "Daniel", 22);
        Manager manager = new Manager("Daniel", 22, "Software Engineer", "IT");

        person.introduce();
        employee.introduce();
        manager.introduce();
    }
}
