import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class StudentResultManagement extends JFrame 
{

    private JTextField StuIdField, NameField, CourseField, ModuleField1, ModuleField2, ModuleField3;
    private JLabel AverageLabel, TotalLabel, PassFailLabel, GpaLabel;
    private JTextArea DistributionArea;
    
    // Color Palette
    private static final Color PRIMARY_COLOR = new Color(25, 118, 210);      // Deep Blue
    private static final Color SECONDARY_COLOR = new Color(56, 142, 60);     // Green
    private static final Color ACCENT_COLOR = new Color(255, 152, 0);        // Orange
    private static final Color BACKGROUND_COLOR = new Color(245, 245, 245);  // Light Gray
    private static final Color TEXT_PRIMARY = new Color(33, 33, 33);         // Dark Text
    private static final Color TEXT_SECONDARY = new Color(117, 117, 117);    // Medium Gray

    public StudentResultManagement()
    {
        setTitle("Student Results Management System");
        setSize(550, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Create main panel with gradient background
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gradient = new GradientPaint(0, 0, PRIMARY_COLOR, 0, getHeight(), new Color(13, 71, 161));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(null);
        setContentPane(mainPanel);

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 550, 80);
        headerPanel.setBackground(PRIMARY_COLOR);
        headerPanel.setLayout(null);
        
        JLabel HeaderLabel = new JLabel("Student Results Management System", JLabel.CENTER);
        HeaderLabel.setBounds(20, 10, 510, 60);
        HeaderLabel.setForeground(Color.WHITE);
        HeaderLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        headerPanel.add(HeaderLabel);
        mainPanel.add(headerPanel);

        // Input Fields Section
        int startY = 100;
        int fieldSpacing = 50;
        
        // Student ID
        JLabel StuIdLabel = createLabel("Student ID", 30, startY, 120, 25);
        mainPanel.add(StuIdLabel);
        StuIdField = createTextField(160, startY, 360, 35);
        mainPanel.add(StuIdField);

        // Student Name
        JLabel NameLabel = createLabel("Name", 30, startY + fieldSpacing, 120, 25);
        mainPanel.add(NameLabel);
        NameField = createTextField(160, startY + fieldSpacing, 360, 35);
        mainPanel.add(NameField);

        // Course
        JLabel CourseLabel = createLabel("Course", 30, startY + fieldSpacing * 2, 120, 25);
        mainPanel.add(CourseLabel);
        CourseField = createTextField(160, startY + fieldSpacing * 2, 360, 35);
        mainPanel.add(CourseField);

        // Module 1
        JLabel Module1Label = createLabel("Accounting", 30, startY + fieldSpacing * 3, 120, 25);
        mainPanel.add(Module1Label);
        ModuleField1 = createTextField(160, startY + fieldSpacing * 3, 360, 35);
        mainPanel.add(ModuleField1);

        // Module 2
        JLabel Module2Label = createLabel("ICT", 30, startY + fieldSpacing * 4, 120, 25);
        mainPanel.add(Module2Label);
        ModuleField2 = createTextField(160, startY + fieldSpacing * 4, 360, 35);
        mainPanel.add(ModuleField2);

        // Module 3
        JLabel Module3Label = createLabel("Economics", 30, startY + fieldSpacing * 5, 120, 25);
        mainPanel.add(Module3Label);
        ModuleField3 = createTextField(160, startY + fieldSpacing * 5, 360, 35);
        mainPanel.add(ModuleField3);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(30, 425, 490, 100);
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(null);
        
        JButton CalculateButton = createStyledButton("Calculate", 10, 10, 115, 40, PRIMARY_COLOR);
        buttonPanel.add(CalculateButton);

        JButton ResetButton = createStyledButton("Reset", 135, 10, 115, 40, SECONDARY_COLOR);
        buttonPanel.add(ResetButton);

        JButton SaveButton = createStyledButton("Save", 260, 10, 115, 40, ACCENT_COLOR);
        buttonPanel.add(SaveButton);

        JButton LoadButton = createStyledButton("Load", 385, 10, 100, 40, new Color(156, 39, 176));
        buttonPanel.add(LoadButton);

        JButton DistributionButton = createStyledButton("Show Distribution", 135, 55, 240, 40, new Color(244, 67, 54));
        buttonPanel.add(DistributionButton);

        mainPanel.add(buttonPanel);

        // Results Panel
        JPanel resultsPanel = new JPanel();
        resultsPanel.setBounds(30, 540, 490, 140);
        resultsPanel.setBackground(new Color(255, 255, 255));
        resultsPanel.setBorder(BorderFactory.createLineBorder(new Color(189, 189, 189), 1));
        resultsPanel.setLayout(null);
        
        AverageLabel = createResultLabel("Average: -", 20, 15, 450, 25);
        resultsPanel.add(AverageLabel);

        TotalLabel = createResultLabel("Total: -", 20, 45, 450, 25);
        resultsPanel.add(TotalLabel);

        PassFailLabel = createResultLabel("Pass/Fail: -", 20, 75, 450, 25);
        resultsPanel.add(PassFailLabel);

        GpaLabel = createResultLabel("GPA: -", 20, 105, 450, 25);
        resultsPanel.add(GpaLabel);
        
        mainPanel.add(resultsPanel);

        // Distribution Section
        JLabel DistributionLabel = new JLabel("Grade Distribution:");
        DistributionLabel.setBounds(30, 690, 490, 25);
        DistributionLabel.setForeground(Color.WHITE);
        DistributionLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        mainPanel.add(DistributionLabel);

        DistributionArea = new JTextArea();
        DistributionArea.setBounds(30, 720, 490, 130);
        DistributionArea.setFont(new Font("Consolas", Font.PLAIN, 12));
        DistributionArea.setEditable(false);
        DistributionArea.setBackground(new Color(255, 255, 255));
        DistributionArea.setForeground(TEXT_PRIMARY);
        DistributionArea.setBorder(BorderFactory.createLineBorder(new Color(189, 189, 189), 1));
        DistributionArea.setMargin(new Insets(10, 10, 10, 10));
        mainPanel.add(DistributionArea);

        // Add action listeners
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
    
    // Helper method to create styled labels
    private JLabel createLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 13));
        return label;
    }
    
    // Helper method to create styled text fields
    private JTextField createTextField(int x, int y, int width, int height) {
        JTextField field = new JTextField();
        field.setBounds(x, y, width, height);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 189, 189), 1),
            new EmptyBorder(5, 8, 5, 8)
        ));
        field.setBackground(Color.WHITE);
        return field;
    }
    
    // Helper method to create styled buttons
    private JButton createStyledButton(String text, int x, int y, int width, int height, Color bgColor) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(darkenColor(bgColor));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor);
            }
        });
        return button;
    }
    
    // Helper method to create result labels
    private JLabel createResultLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setForeground(TEXT_PRIMARY);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return label;
    }
    
    // Darken color for hover effect
    private Color darkenColor(Color color) {
        return new Color(
            Math.max(0, color.getRed() - 20),
            Math.max(0, color.getGreen() - 20),
            Math.max(0, color.getBlue() - 20)
        );
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

            AverageLabel.setText("Average: " + String.format("%.2f", average));
            TotalLabel.setText("Total: " + total);
            PassFailLabel.setText("Pass/Fail: " + passFail);
            GpaLabel.setText("GPA: " + String.format("%.2f", gpa));
        } catch (NumberFormatException Ex) {
            JOptionPane.showMessageDialog(this, "Invalid value entered! Please check your input.", "Error", JOptionPane.ERROR_MESSAGE);
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
        AverageLabel.setText("Average: -");
        TotalLabel.setText("Total: -");
        PassFailLabel.setText("Pass/Fail: -");
        GpaLabel.setText("GPA: -");
        DistributionArea.setText("");
    }

    private void saveRecord() 
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

            FileHandler.saveStudentRecord(student, average, total, passFail, gpa);
            JOptionPane.showMessageDialog(this, "Record saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please fill all fields with valid values.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadRecord() 
    {
        String stuId = StuIdField.getText();
        if (stuId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Student ID to load.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Student student = FileHandler.loadStudentRecord(stuId);

        if (student != null) {
            StuIdField.setText(student.getStudentId());
            NameField.setText(student.getName());
            CourseField.setText(student.getCourse());
            ModuleField1.setText(String.valueOf(student.getModule1()));
            ModuleField2.setText(String.valueOf(student.getModule2()));
            ModuleField3.setText(String.valueOf(student.getModule3()));
            calculateResults();
            JOptionPane.showMessageDialog(this, "Record loaded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } 
        else 
        {
            JOptionPane.showMessageDialog(this, "Record not found!", "Not Found", JOptionPane.WARNING_MESSAGE);
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
