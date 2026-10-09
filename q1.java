import java.util.ArrayList;
import java.util.Scanner;

class q1 {
    ArrayList<String> books = new ArrayList<>();

    void addBook(String title) {
        books.add(title);
        System.out.println("Book added successfully.");
    }

    void removeBook(String title) {
        if (books.remove(title))
            System.out.println("Book removed successfully.");
        else
            System.out.println("Book not found.");
    }

    void displayBooks() {
        System.out.println("Current Books: " + books);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        q1 lib = new q1();
        int choice;

        do {
            System.out.println("\n1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    lib.addBook(sc.nextLine());
                    break;

                case 2:
                    System.out.print("Enter book title: ");
                    lib.removeBook(sc.nextLine());
                    break;

                case 3:
                    lib.displayBooks();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}

