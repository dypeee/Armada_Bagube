
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Student extends Person {
    int grade;

    Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }
    
    public void displayGrade() {
        System.out.println("Grade: " + grade);
    }
   
}

public class main {
    public static void main(String[] args) {
        Student student = new Student("Daniel", 22, 100);
        student.displayInfo();
        student.displayGrade();
    }
}
