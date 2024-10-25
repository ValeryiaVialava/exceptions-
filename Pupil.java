public class Pupil {
    private int grades [];
    private int numberOfGrades;
    private String name;
    private String surname;

    public Pupil(int grades[], int numberOfGrades, String name, String surname) {
        this.grades = grades;
        this.numberOfGrades = numberOfGrades;
        this.name = name;
        this.surname = surname;
    }

    public double average (){
        double sum = 0;
        for (int i = 0; i < numberOfGrades; i++) {
            sum += grades[i];
        }
        return sum / numberOfGrades;
    }

    public void print (){
        System.out.println(this.name + " " + this.surname + " has " + this.numberOfGrades + " grades");
        System.out.print("Grades: ");
        for (int i = 0; i < numberOfGrades; i++) {
            System.out.print(this.grades[i] + " ");
        }
        System.out.println();
    }

    public int getGrade(int number) {
        return grades[number-1];
    }
}
