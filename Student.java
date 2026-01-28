public class Student {
    private String studentId;
    private String name;
    private String course;
    private double module1;
    private double module2;
    private double module3;

    public Student(String studentId, String name, String course, double module1, double module2, double module3) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.module1 = module1;
        this.module2 = module2;
        this.module3 = module3;
    }

    public String getStudentId() 
    { 
        return studentId;
    }
    public String getName()
    { 
        return name; 
    }
    public String getCourse() 
    { 
        return course; 
    }
    public double getModule1() 
    { 
        return module1; 
    }
    public double getModule2() 
    { 
        return module2; 
    }
    public double getModule3() 
    { 
        return module3; 
    }
}
