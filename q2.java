
import java.util.HashSet;
import java.util.Scanner;

class q2 {
    HashSet<String> students = new HashSet<>();

    void markAttendance(String name) {
        if (students.add(name))
            System.out.println("Attendance marked for " + name);
        else
            System.out.println(name + " is already marked present");
    }

    void displayAttendance() {
        System.out.println("Present Students: " + students);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        q2 a = new q2();

        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter name to mark attendance: ");
            String name = sc.nextLine();
            a.markAttendance(name);
        }

        a.displayAttendance();
        sc.close();
    }
}



