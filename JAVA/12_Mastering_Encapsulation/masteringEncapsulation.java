
class Student{
    private String name;
    private int age;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public int age(){
        return age;
    }
    public void setAge(int age){
        if(age > 0){
            this.age = age;
        }else{
            System.out.println("Age must be positive");
        }
    }

    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

    }
    
}

public class masteringEncapsulation {
    public static void main(String[] args) {
        Student student = new Student("Daniel", 22);
        student.displayInfo();
    }
}
