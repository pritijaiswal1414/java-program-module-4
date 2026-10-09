
import java.util.LinkedHashSet;
import java.util.Scanner;

class q5 {
    LinkedHashSet<String> students = new LinkedHashSet<>();

    void enrollStudent(String name) {
        if (students.add(name))
            System.out.println("Enrolled: " + name);
        else
            System.out.println(name + " is already enrolled");
    }

    void displayEnrolledStudents() {
        System.out.println("Enrolled Students: " + students);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        q5 course = new q5();

        for (int i = 1; i <= 3; i++) {
            System.out.print("Enroll: ");
            course.enrollStudent(sc.nextLine());
        }

        course.displayEnrolledStudents();
        sc.close();
    }
}

