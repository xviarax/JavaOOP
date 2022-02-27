package studentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> students;

    public StudentSystem()
    {
        this.students = new HashMap<>();
    }
    public Map<String, Student> getRepo() {
        return this.students;
    }

    public void executeCommand(String[] commandParts) {
        String commandName =  commandParts[0];
        if ("Create".equals(commandName)) {
            createStudent(commandParts);
        } else if ("Show".equals(commandName)) {
            showStudent(commandParts[1]);
        }
    }

    private void showStudent(String name) {
        if (students.containsKey(name)) {
            Student student = students.get(name);
            StringBuilder output = new StringBuilder(student.toString());

            if (student.getGrade() >= 5.00) {
                output.append(" Excellent student.");
            } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                output.append(" Average student.");
            } else {
                output.append(" Very nice person.");
            }
            System.out.println(output);
        }
    }

    private void createStudent(String[] commandParts) {
        String name =  commandParts[1];
        int age = Integer.parseInt( commandParts[2]);
        double grade = Double.parseDouble( commandParts[3]);
        Student student = new Student(name, age, grade);
        students.putIfAbsent(name, student);
    }
}
