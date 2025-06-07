import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

interface Archivable {
    void archive();
}

class Student implements Archivable {
    private String student_name, student_id;
    private ArrayList<Subject> subjects;

    Student(String student_name, String student_id, ArrayList<Subject> subjects) {
        this.student_name = student_name;
        this.student_id = student_id;
        this.subjects = subjects;
    }

    public String get_student_name() {
        return student_name;
    }

    public void set_student_name(String new_name) {
        this.student_name = new_name;
    }

    public String get_student_id() {
        return student_id;
    }

    public ArrayList<Subject> get_subjects() {
        return subjects;
    }

    public double calculateGPA() {
        ArrayList<Double> grades = new ArrayList<>();
        if (subjects != null) {
            for (Subject subject : subjects) {
                grades.add(subject.get_grade());
            }
        }
        Transcript transcript = new Transcript(grades);
        return transcript.calculateGPA();
    }

    public void archive() {
        if (calculateGPA() >= 3.5) {
            System.out.println("ID:" + get_student_id() + ", Name: " + get_student_name() + ", GPA: " + calculateGPA());
        }
    }

    public String toString() {
        return student_id + "\t\t| " + student_name + "\t\t";
    }

}

class Subject {
    private String code, description;
    private Double grade;

    Subject(String code, String description, Double grade) {
        this.code = code;
        this.description = description;
        this.grade = grade;
    }

    public String get_code() {
        return code;
    }

    public String get_description() {
        return description;
    }

    public Double get_grade() {
        return grade;
    }

    public String toFileString() {
        return code + "," + description + "," + grade;
    }

    public String toString() {
        return "\t" + code + "," + description + "," + grade;
    }
}

class Transcript {
    private ArrayList<Double> grades;

    Transcript(ArrayList<Double> grades) {
        this.grades = grades;
    }

    public ArrayList<Double> get_grade() {
        return grades;
    }

    public double calculateGPA() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double totalGradePoints = 0.0;
        for (Double grade : grades) {
            totalGradePoints += grade;
        }
        return totalGradePoints / grades.size();
    }

}

public class Main {
    
    public static void load_records(ArrayList<Student> students) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] studentData = line.split(",");

                String studentID = studentData[0].trim();
                String studentName = studentData[1].trim();
                ArrayList<Subject> subjects = new ArrayList<>();

                for (int i = 2; i < studentData.length; i += 3) {
                    if (i + 2 < studentData.length) {
                        String subjectCode = studentData[i].trim();
                        String subjectDescription = studentData[i + 1].trim();
                        double subjectGrade;
                        subjectGrade = Double.parseDouble(studentData[i + 2].trim());
                        subjects.add(new Subject(subjectCode, subjectDescription, subjectGrade));
                    }
                }
                students.add(new Student(studentName, studentID, subjects));
            }
            System.out.println("Student records loaded successfully!\n");
        } catch (IOException e) {
            System.out.println("Something went wrong while loading the data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Double> grades = new ArrayList<>();
        int choice = 0;
        boolean exists = false, add_more = true;
        String id, code, description, response;
        Double grade;
        load_records(students);

        while (choice != 7) {
            System.out.println("\n======= Welcome to SRMS =======");
            System.out.println("[1] Add Student");
            System.out.println("[2] Update Student");
            System.out.println("[3] Add Subject");
            System.out.println("[4] Display Transcript");
            System.out.println("[5] View All Students");
            System.out.println("[6] Archive students based on GPA");
            System.out.println("[7] Save and Exit");
            System.out.println("-------------------------");
            System.out.print("Choice: ");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("-------------------------");
                    System.out.print("Enter Student Name: ");
                    String name = scan.nextLine();
                    System.out.println();
                    exists = false;

                    for (Student student : students) {
                        if (student.get_student_name().equals(name)) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.print("Add " + name + " again? (Y/N): ");
                        response = scan.nextLine();
                        while (true) {
                            if (response.equalsIgnoreCase("Y")) {
                                int student_count = students.size() + 1;
                                String student_id = "UCU" + String.format("%03d", student_count);
                                Student new_student = new Student(name, student_id, new ArrayList<>());
                                students.add(new_student);
                                System.out.println("Student added.");
                                break;
                            } else if (response.equalsIgnoreCase("N")) {
                                System.out.println("Student not added.");
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                                response = scan.nextLine();
                            }
                        }
                    } else {
                        int student_count = students.size() + 1;
                        String student_id = "UCU" + String.format("%03d", student_count);
                        Student new_student = new Student(name, student_id, new ArrayList<>());
                        students.add(new_student);
                        System.out.println("Student added.");
                    }

                    System.out.println("-------------------------");
                    break;

                case 2:
                    System.out.println("-------------------------");
                    System.out.print("Enter Student ID: ");
                    id = scan.nextLine();

                    for (Student student : students) {
                        if (student.get_student_id().equals(id)) {
                            System.out.print("Enter New Student Name: ");
                            String new_name = scan.nextLine();
                            student.set_student_name(new_name);
                            break;
                        } else {
                            System.out.println("Record not Found!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("-------------------------");
                    System.out.print("Enter Student ID: ");
                    id = scan.nextLine();

                    Student found_student = null;
                    ArrayList<Subject> subjects = new ArrayList<>();

                    for (Student student : students) {
                        if (student.get_student_id().equals(id)) {
                            found_student = student;
                            break;
                        }
                    }

                    if (found_student == null) {
                        System.out.println("Record not Found!");
                    } else {
                        add_more = true;
                        subjects.clear();

                        while (add_more) {
                            System.out.print("Enter Code: ");
                            code = scan.nextLine();
                            System.out.print("Enter Description: ");
                            description = scan.nextLine();

                            while (true) {
                                try {
                                    System.out.print("Enter Grade (0.0 - 4.0): ");
                                    grade = scan.nextDouble();
                                    if (grade >= 0.0 && grade <= 4.0) {
                                        break;
                                    } else {
                                        System.out.println("Invalid input. Grade must be between 0.0 and 4.0.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Invalid input. Please enter a number.");
                                    scan.nextLine();
                                }
                            }

                            scan.nextLine();

                            Subject newSubject = new Subject(code, description, grade);
                            subjects.add(newSubject);

                            System.out.println("Added Subject Successfully!\n");
                            System.out.print("Add more subject? (Y/N): ");
                            response = scan.nextLine();

                            if (!response.equalsIgnoreCase("Y")) {
                                add_more = false;
                            }
                        }

                        found_student.get_subjects().addAll(subjects);
                    }

                    break;

                case 4:
                    System.out.println("-------------------------");
                    System.out.print("Enter Student ID: ");
                    id = scan.nextLine();

                    for (Student student : students) {
                        if (student.get_student_id().equals(id)) {
                            System.out.println("-------------------------");
                            System.out.println("ID: " + student.get_student_id());
                            System.out.println("Name: " + student.get_student_name());
                            grades.clear();
                            for (Subject subject : student.get_subjects()) {
                                System.out.println(subject.toString());
                                grades.add(subject.get_grade());
                            }
                            Transcript record = new Transcript(grades);
                            double gpa = record.calculateGPA();
                            System.out.println("GPA: " + gpa);
                            break;
                        } else {
                            System.out.println("Record not Found!");
                        }
                    }
                    break;

                case 5:
                    System.out.println("-------------------------");
                    System.out.println("[1] Sort student list alphabetically by NAME");
                    System.out.println("[2] Sort student list by GPA");
                    System.out.print("Choice: ");
                    choice = scan.nextInt();
                    scan.nextLine();

                    switch (choice) {
                        case 1:
                            for (int i = 0; i < students.size(); i++) {
                                for (int j = 0; j < students.size() - i - 1; j++) {
                                    if (students.get(j).get_student_name().compareTo(students.get(j + 1).get_student_name()) > 0) {
                                        Student temp = students.get(j);
                                        students.set(j, students.get(j + 1));
                                        students.set(j + 1, temp);
                                    }
                                }
                            }
                            break;

                        case 2:
                            for (int i = 0; i < students.size(); i++) {
                                for (int j = 0; j < students.size() - i - 1; j++) {
                                    if (students.get(j).calculateGPA() < students.get(j + 1).calculateGPA()) {
                                        Student temp = students.get(j);
                                        students.set(j, students.get(j + 1));
                                        students.set(j + 1, temp);
                                    }
                                }
                            }
                            break;

                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }

                    System.out.println("ID\t\t| Name \t\t\t\t| GPA");
                    for (Student student : students) {
                        System.out.println(student.toString() + "| " + student.calculateGPA());
                    }
                    break;

                case 6:
                    System.out.println("-------------------------");
                    double gpaThreshold = 3.5;

                    System.out.println("Archive Students:");
                    for (Student student : students) {
                        if (student.calculateGPA() >= gpaThreshold) {
                            student.archive();
                        }
                    }
                    break;

                case 7:
                    // Save student records to a text file
                    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("students.txt"))) {
                        for (Student student : students) {
                            bufferedWriter.write(student.get_student_id() + "," + student.get_student_name());

                            for (Subject subjectData : student.get_subjects()) {
                                bufferedWriter.write("," + subjectData.toFileString());
                            }
                            bufferedWriter.newLine();
                        }
                        System.out.println("Student records saved successfully!\n");
                        students.clear();

                    } catch (IOException e) {
                        System.out.println("Something went wrong while saving the updated data: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        scan.close();
    }

}
