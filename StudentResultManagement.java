import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StudentResultManagement extends JFrame 
{

    private JTextField StuIdField, NameField, CourseField, ModuleField1, ModuleField2, ModuleField3;
    private JLabel AverageLabel, TotalLabel, PassFailLabel, GpaLabel;
    private JTextArea DistributionArea;

    public StudentResultManagement()
    {
        setTitle("Student's Results Management System");
        setSize(450, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(0, 0, 128));

        JLabel HeaderLabel = new JLabel("Student's Results Management System", JLabel.CENTER);
        HeaderLabel.setBounds(20, 20, 400, 40);
        HeaderLabel.setForeground(Color.WHITE);
        HeaderLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(HeaderLabel);

        JLabel StuIdLabel = new JLabel("Stu ID");
        StuIdLabel.setBounds(50, 80, 100, 25);
        StuIdLabel.setForeground(Color.WHITE);
        add(StuIdLabel);

        StuIdField = new JTextField();
        StuIdField.setBounds(170, 80, 200, 30);
        StuIdField.setFont(new Font("Arial", Font.PLAIN, 14));
        add(StuIdField);

        JLabel NameLabel = new JLabel("Student name");
        NameLabel.setBounds(50, 120, 100, 25);
        NameLabel.setForeground(Color.WHITE);
        add(NameLabel);

        NameField = new JTextField();
        NameField.setBounds(170, 120, 200, 30);
        NameField.setFont(new Font("Arial", Font.PLAIN, 14));
        add(NameField);

        JLabel CourseLabel = new JLabel("Course");
        CourseLabel.setBounds(50, 160, 100, 25);
        CourseLabel.setForeground(Color.WHITE);
        add(CourseLabel);

        CourseField = new JTextField();
        CourseField.setBounds(170, 160, 200, 30);
        CourseField.setFont(new Font("Arial", Font.PLAIN, 14));
        add(CourseField);

        JLabel Module1Label = new JLabel("Account");
        Module1Label.setBounds(50, 200, 100, 25);
        Module1Label.setForeground(Color.WHITE);
        add(Module1Label);

        ModuleField1 = new JTextField();
        ModuleField1.setBounds(170, 200, 200, 30);
        ModuleField1.setFont(new Font("Arial", Font.PLAIN, 14));
        add(ModuleField1);

        JLabel Module2Label = new JLabel("ICT");
        Module2Label.setBounds(50, 240, 100, 25);
        Module2Label.setForeground(Color.WHITE);
        add(Module2Label);

        ModuleField2 = new JTextField();
        ModuleField2.setBounds(170, 240, 200, 30);
        ModuleField2.setFont(new Font("Arial", Font.PLAIN, 14));
        add(ModuleField2);

        JLabel Module3Label = new JLabel("Econ");
        Module3Label.setBounds(50, 280, 100, 25);
        Module3Label.setForeground(Color.WHITE);
        add(Module3Label);

        ModuleField3 = new JTextField();
        ModuleField3.setBounds(170, 280, 200, 30);
        ModuleField3.setFont(new Font("Arial", Font.PLAIN, 14));
        add(ModuleField3);

        JButton CalculateButton = new JButton("Calculate");
        CalculateButton.setBounds(50, 330, 150, 40);
        CalculateButton.setFont(new Font("Arial", Font.BOLD, 14));
        add(CalculateButton);

        JButton ResetButton = new JButton("Reset");
        ResetButton.setBounds(220, 330, 150, 40);
        ResetButton.setFont(new Font("Arial", Font.BOLD, 14));
        add(ResetButton);

        JButton SaveButton = new JButton("Save");
        SaveButton.setBounds(50, 370, 150, 40);
        SaveButton.setFont(new Font("Arial", Font.BOLD, 14));
        add(SaveButton);

        JButton LoadButton = new JButton("Load");
        LoadButton.setBounds(220, 370, 150, 40);
        LoadButton.setFont(new Font("Arial", Font.BOLD, 14));
        add(LoadButton);

        AverageLabel = new JLabel("Average : -");
        AverageLabel.setBounds(50, 430, 200, 25);
        AverageLabel.setForeground(Color.WHITE);
        AverageLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(AverageLabel);

        TotalLabel = new JLabel("Total : -");
        TotalLabel.setBounds(50, 470, 200, 25);
        TotalLabel.setForeground(Color.WHITE);
        TotalLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(TotalLabel);

        PassFailLabel = new JLabel("Pass/Fail : -");
        PassFailLabel.setBounds(50, 510, 200, 25);
        PassFailLabel.setForeground(Color.WHITE);
        PassFailLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(PassFailLabel);

        GpaLabel = new JLabel("GPA : -");
        GpaLabel.setBounds(50, 550, 200, 25);
        GpaLabel.setForeground(Color.WHITE);
        GpaLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(GpaLabel);

        JLabel DistributionLabel = new JLabel("Grade Distribution:");
        DistributionLabel.setBounds(50, 590, 200, 25);
        DistributionLabel.setForeground(Color.WHITE);
        DistributionLabel.setFont(new Font("Arial", Font.BOLD, 17));
        add(DistributionLabel);

        DistributionArea = new JTextArea();
        DistributionArea.setBounds(50, 620, 350, 100);
        DistributionArea.setFont(new Font("Arial", Font.PLAIN, 14));
        DistributionArea.setEditable(false);
        add(DistributionArea);

        JButton DistributionButton = new JButton("Show Distribution");
        DistributionButton.setBounds(220, 730, 150, 40);
        DistributionButton.setFont(new Font("Arial", Font.BOLD, 14));
        add(DistributionButton);

        CalculateButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                calculateResults();
            }
        });

        ResetButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                resetFields();
            }
        });

        SaveButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                saveRecord();
            }
        });

        LoadButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                loadRecord();
            }
        });

        DistributionButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                calculateGradeDistribution();
            }
        });

        setVisible(true);
    }

    private void calculateResults() 
    {
        try {
            Student student = new Student(
                StuIdField.getText(),
                NameField.getText(),
                CourseField.getText(),
                Double.parseDouble(ModuleField1.getText()),
                Double.parseDouble(ModuleField2.getText()),
                Double.parseDouble(ModuleField3.getText())
            );

            double total = ResultCalculator.calculateTotal(student);
            double average = ResultCalculator.calculateAverage(student);
            String passFail = ResultCalculator.determinePassFail(average);
            double gpa = ResultCalculator.calculateGPA(average);

            AverageLabel.setText("Average : " + String.format("%.2f", average));
            TotalLabel.setText("Total : " + total);
            PassFailLabel.setText("Pass/Fail : " + passFail);
            GpaLabel.setText("GPA : " + String.format("%.2f", gpa));
        } catch (NumberFormatException Ex) {
            JOptionPane.showMessageDialog(this, "INVALID VALUE !!!!!! ENTER AGAIN");
        }
    }

    private void resetFields() 
    {
        StuIdField.setText("");
        NameField.setText("");
        CourseField.setText("");
        ModuleField1.setText("");
        ModuleField2.setText("");
        ModuleField3.setText("");
        AverageLabel.setText("Average : -");
        TotalLabel.setText("Total : -");
        PassFailLabel.setText("Pass/Fail : -");
        GpaLabel.setText("GPA : -");
    }

    private void saveRecord() 
    {
        Student student = new Student(
            StuIdField.getText(),
            NameField.getText(),
            CourseField.getText(),
            Double.parseDouble(ModuleField1.getText()),
            Double.parseDouble(ModuleField2.getText()),
            Double.parseDouble(ModuleField3.getText())
        );

        double total = ResultCalculator.calculateTotal(student);
        double average = ResultCalculator.calculateAverage(student);
        String passFail = ResultCalculator.determinePassFail(average);
        double gpa = ResultCalculator.calculateGPA(average);

        FileHandler.saveStudentRecord(student, average, total, passFail, gpa);
        JOptionPane.showMessageDialog(this, "Record saved successfully!");
    }

    private void loadRecord() 
    {
        String stuId = StuIdField.getText();
        Student student = FileHandler.loadStudentRecord(stuId);

        if (student != null) {
            StuIdField.setText(student.getStudentId());
            NameField.setText(student.getName());
            CourseField.setText(student.getCourse());
            ModuleField1.setText(String.valueOf(student.getModule1()));
            ModuleField2.setText(String.valueOf(student.getModule2()));
            ModuleField3.setText(String.valueOf(student.getModule3()));
            calculateResults();
        } 
        else 
        {
            JOptionPane.showMessageDialog(this, "Record not found!");
        }
    }

    private void calculateGradeDistribution() 
    {
        String[] grades = {"85", "90", "78", "92", "88", "76"};
        String distribution = ResultCalculator.calculateGradeDistribution(grades);
        DistributionArea.setText(distribution);
    }

    public static void main(String[] Args) 
    {
        new StudentResultManagement();
    }
}
