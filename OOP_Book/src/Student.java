public class Student {
    private String name;
    private String group;
    private byte[] grades;
    float res;

    public Student(String name, String group, byte[] grades){
        this.name = name;
        this.group = group;
        this.grades = grades;
    }
    public float getAverageGrades(){
        float sum = 0;
        for(int i = 0; i < grades.length; i++){
            sum = sum + grades[i];

        }
         res = sum/grades.length;
        return res;
    }
    public void displayInfo(){
        System.out.println("Name student: " + name + "\nGroup student: "
        + "\nAverage grades: " + res);
    }

}
