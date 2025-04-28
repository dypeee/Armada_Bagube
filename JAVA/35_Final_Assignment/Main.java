import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

interface Archivable {
    void archive();
}

class Student implements Archivable {
    String name, ID;
    ArrayList<Subject> subjects;

    Student(String name, String ID, ArrayList<Subject> subjects) {
        this.name = name;
        this.ID = ID;
        this.subjects = subjects;
    }

    public void archive() {
        if (calculateGPA() >= 3.5) {
            System.out.println("ID:" + ID + ", Name: " + name + ", GPA: " + calculateGPA());
        }
    }

    public double calculateGPA() {
        double totalGradePoints = 0.0;
        for (Subject subject : subjects) {
            totalGradePoints += subject.grade;
        }
        return totalGradePoints / subjects.size();
    }

    public String toString() {
        return "Student ID: " + ID + ", Name: " + name + ", Subjects: " + subjects.size() + " subject(s)";
    }
}

class Subject {
    String code, description;
    double grade;

    Subject(String code, String description, double grade) {
        this.code = code;
        this.description = description;
        this.grade = grade;
    }

    public String toFileString() {
        return code + "," + description + "," + grade;
    }

    public String toString() {
        return "[" + code + " - " + description + ", Grade: " + grade + "]";
    }

}

class Transcript {
    double gpa;

    Transcript(double gpa) {
        this.gpa = gpa;
    }

    void display() {
        System.out.printf("GPA: %.2f\n", gpa);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        String ID, description, code, name;
        double grade = -1;
        boolean isExistingStudent;
        ArrayList<Student> Students = new ArrayList<>();

        // Load records from the file when the program starts
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] studentData = line.split(",");

                if (studentData.length < 3) {
                    System.out.println("Skipping invalid student record: " + line);
                    continue;
                }

                String studentID = studentData[0].trim();
                String studentName = studentData[1].trim();
                ArrayList<Subject> subjects = new ArrayList<>();

                //Trim the raw data and distribute base on the Student constructor
                for (int i = 2; i < studentData.length; i += 3) {
                    if (i + 2 < studentData.length) {
                        String subjectCode = studentData[i].trim();
                        String subjectDescription = studentData[i + 1].trim();
                        double subjectGrade;

                        try {
                            subjectGrade = Double.parseDouble(studentData[i + 2].trim());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid grade format for subject: " + studentData[i + 2]);
                            continue;
                        }
                        subjects.add(new Subject(subjectCode, subjectDescription, subjectGrade));
                    }
                }

                Students.add(new Student(studentName, studentID, subjects));
            }
            System.out.println("Student records loaded successfully!\n");
        } catch (IOException e) {
            System.out.println("Something went wrong while loading the data: " + e.getMessage());
        }

        while (choice != 6) {
            System.out.println("-----Welcome to SRMS-----");
            System.out.println("[1] Add/Update Student");
            System.out.println("[2] Add Subject");
            System.out.println("[3] Display Transcript");
            System.out.println("[4] View All Students");
            System.out.println("[5] Archive students based on GPA");
            System.out.println("[6] Save and Exit");
            System.out.println("-------------------------");
            System.out.print("Choice: ");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("--- Add/Update Student ---");
                    System.out.print("Enter Student ID: ");
                    ID = scan.nextLine();

                    isExistingStudent = false;


                    for (Student student : Students) {
                        //If the student is existing it will update the name
                        if (student.ID.equals(ID)) {
                            System.out.print("Enter new Student Name: ");
                            String newName = scan.nextLine();
                            student.name = newName;
                            isExistingStudent = true;
                            break;
                        }
                    }
                    
                    //If the student is not existing it will add the ID and name
                    if (!isExistingStudent) {
                        System.out.print("Enter Student Name: ");
                        name = scan.nextLine();

                        Student newStudent = new Student(name, ID, new ArrayList<>());
                        Students.add(newStudent);

                        System.out.println("New student added successfully.");
                    }

                    break;

                case 2:
                    System.out.println("--- Add Subject ---");
                    System.out.print("Enter Student ID: ");
                    ID = scan.nextLine();

                    //Check if its exisitng
                    Student foundStudent = null;
                    for (Student student : Students) {
                        if (student.ID.equals(ID)) {
                            foundStudent = student;
                            break;
                        }
                    }

                    if (foundStudent != null) {
                        ArrayList<Subject> subjectsToAdd = new ArrayList<>();
                        boolean addMore = true;

                        //Add multiple subjects and corresponding grades per student
                        while (addMore) {
                            System.out.print("Enter Subject Code: ");
                            code = scan.nextLine();
                            System.out.print("Enter Description: ");
                            description = scan.nextLine();

                            //Enter Grade as long as valid
                            while (true) {
                                System.out.print("Enter Grade (0.0 - 4.0): ");
                                try {
                                    grade = scan.nextDouble();
                                    scan.nextLine();
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

                            Subject newSubject = new Subject(code, description, grade);
                            subjectsToAdd.add(newSubject);

                            System.out.print("Add another subject? (Y/N): ");
                            String response = scan.nextLine();
                            if (!response.equalsIgnoreCase("Y")) {
                                addMore = false;
                            }
                        }

                        foundStudent.subjects.addAll(subjectsToAdd);
                        System.out.println("Subjects added successfully!");

                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.println("--- Display Transcript ---");
                    System.out.print("Enter Student ID: ");
                    ID = scan.nextLine();
                    //Display a student's transcript with computed GPA
                    for (Student student : Students) {
                        if (student.ID.equals(ID)) {
                            double gpa = student.calculateGPA();

                            Transcript transcript = new Transcript(gpa);
                            System.out.println("Student ID: " + student.ID);
                            System.out.println("Name: " + student.name);

                            if (student.subjects.isEmpty()) {
                                System.out.println("No subjects recorded.");
                            } else {
                                System.out.println("Subjects:");
                                for (Subject subject : student.subjects) {
                                    System.out.println("   - " + subject);
                                }
                            }

                            transcript.display();
                            break;
                        }
                    }
                    break;

                case 4:
                    
                    System.out.println("--- View All Students ---");
                    System.out.println("[1] Sort student list alphabetically by NAME");
                    System.out.println("[2] Sort student list by GPA");
                    System.out.print("Choice: ");
                    choice = scan.nextInt();
                    scan.nextLine();

                     
                    switch (choice) {
                        //Sort student list alphabetically by name
                        case 1:
                            for (int i = 0; i < Students.size(); i++) {
                                for (int j = i + 1; j < Students.size(); j++) {
                                    if (Students.get(i).name.compareTo(Students.get(j).name) > 0) {
                                        Student temp = Students.get(i);
                                        Students.set(i, Students.get(j));
                                        Students.set(j, temp);
                                    }
                                }
                            }
                            System.out.println("Student list sorted by name:");
                            break;
                        //Sort student list alphabetically by GPA
                        case 2:
                            for (int i = 0; i < Students.size(); i++) {
                                for (int j = i + 1; j < Students.size(); j++) {
                                    if (Students.get(i).calculateGPA() < Students.get(j).calculateGPA()) {
                                        Student temp = Students.get(i);
                                        Students.set(i, Students.get(j));
                                        Students.set(j, temp);
                                    }
                                }
                            }
                            System.out.println("Student list sorted by GPA:");
                            break;

                        default:
                            System.out.println("Invalid choice. Please select 1 or 2.");
                            break;
                    }

                    for (Student student : Students) {
                        System.out.println("ID: " + student.ID + ", Name: " + student.name);
                    }
                    break;

                case 5:
                    //Archive students based on GPA threshold (e.g., 3.5+ considered for graduation)
                    System.out.println("--- Archive students based on GPA ---");
                    double gpaThreshold = 3.5;

                    System.out.println("Archive Students:");
                    for (Student student : Students) {
                        if (student.calculateGPA() >= gpaThreshold) {
                            student.archive();
                        }
                    }
                    break;

                case 6:
                    //Save student records to a .txt file
                    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("students.txt"))) {
                        for (Student student : Students) {
                            bufferedWriter.write(student.ID + "," + student.name);

                            for (Subject subjectData : student.subjects) {
                                bufferedWriter.write("," + subjectData.toFileString());
                            }
                            bufferedWriter.newLine();
                        }
                        System.out.println("Student records saved successfully!\n");

                    } catch (IOException e) {
                        System.out.println("Something went wrong while saving the updated data: " + e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        scan.close();

    }
}
