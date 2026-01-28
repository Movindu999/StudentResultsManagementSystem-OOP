import java.io.*;

public class FileHandler 
{

    public static void saveStudentRecord(Student student, double average, double total, String passFail, double gpa) 
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("student_records.txt", true))) 
        {
            writer.write("Student ID: " + student.getStudentId() + ", Name: " + student.getName() + 
                        ", Course: " + student.getCourse() +
                        ", Module1: " + student.getModule1() + ", Module2: " + student.getModule2() + 
                        ", Module3: " + student.getModule3() +
                        ", Average: " + average + ", Total: " + total + ", Pass/Fail: " + passFail + 
                        ", GPA: " + gpa);
            writer.newLine();
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }

    public static Student loadStudentRecord(String studentId) 
    {
        try (BufferedReader reader = new BufferedReader(new FileReader("student_records.txt"))) 
        {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Student ID: " + studentId)) 
                {
                    String[] parts = line.split(", ");
                    return new Student(
                        parts[0].split(": ")[1],
                        parts[1].split(": ")[1],
                        parts[2].split(": ")[1],
                        Double.parseDouble(parts[3].split(": ")[1]),
                        Double.parseDouble(parts[4].split(": ")[1]),
                        Double.parseDouble(parts[5].split(": ")[1])
                    );
                }
            }
        }
         catch (IOException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
}
