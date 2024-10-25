import java.util.Scanner;
import java.util.InputMismatchException;


public class Main {
    public static void main(String[] args) {
        String name,surname;
        int numberOfGrades;
        int[] grades;
        Scanner scan=new Scanner(System.in);

        System.out.println("Name: ");
        name = scan.next(); // or scan.nextLine()

        System.out.println("Surname: ");
            surname = scan.next();

        while (true) {
            try {
                System.out.println("Number of grades: ");
                numberOfGrades = scan.nextInt();
                if (numberOfGrades < 0) throw new IllegalArgumentException("Number of grades must be positive");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scan.next(); // clearing incorrect input
            }
        }

        grades = new int[numberOfGrades];
        System.out.println("Enter grades: ");

        for (int i = 0; i < numberOfGrades; i++) {
            while (true) {
                try {
                    grades[i] = scan.nextInt();
                    if (grades[i] < 1 || grades[i] > 6)
                        throw new IllegalArgumentException("Grade must be between 1 and 6. Please, try again.");
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number.");
                    scan.next();  // clearing incorrect input
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        Pupil p1 = new Pupil(grades, numberOfGrades, name, surname);
        int answer=1;

        while(answer!=4) {
            printMenu();
            answer=scan.nextInt();
            try {
                switch(answer) {
                    case 1 -> System.out.println("average: " + p1.average());
                    case 2 -> p1.print();
                    case 3 -> {
                        System.out.println("Which grade: ");
                        int number=scan.nextInt();
                        if (number < 1 || number > numberOfGrades) throw new ArrayIndexOutOfBoundsException("Invalid grade");
                        System.out.println("Grade: " + p1.getGrade(number));
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scan.next(); // clearing incorrect input
            } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
            } finally {
                    System.out.println("****************END " + answer + " ****************");
            }
        }
    }

    private static void printMenu() {
        System.out.println ("----------");
        System.out.println("1. Average");
        System.out.println("2. Print");
        System.out.println("3. Print grade");
        System.out.println("4. Exit");
        System.out.println ("----------");
    }
}