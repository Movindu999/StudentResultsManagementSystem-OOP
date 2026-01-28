public class ResultCalculator {

    public static double calculateTotal(Student student) 
    {
        return student.getModule1() + student.getModule2() + student.getModule3();
    }

    public static double calculateAverage(Student student) 
    {
        return calculateTotal(student) / 3;
    }

    public static String determinePassFail(double average) 
    {
        return average >= 50 ? "Pass" : "Fail";
    }

    public static double calculateGPA(double average) 
    {
        return (average / 100) * 4;
    }

    public static String calculateGradeDistribution(String[] grades) 
    {
        int[] ranges = new int[5];

        for (String grade : grades) {
            int score = Integer.parseInt(grade);
            if (score < 50) ranges[0]++;
            else if (score < 60) ranges[1]++;
            else if (score < 70) ranges[2]++;
            else if (score < 80) ranges[3]++;
            else ranges[4]++;
        }

        return "Grade Distribution:\n" +
                "0-49: " + ranges[0] + "\n" +
                "50-59: " + ranges[1] + "\n" +
                "60-69: " + ranges[2] + "\n" +
                "70-79: " + ranges[3] + "\n" +
                "80-100: " + ranges[4];
    }
}
