
import java.util.HashMap;
import java.util.Scanner;

class q3 {
    HashMap<Integer, String> accounts = new HashMap<>();

    void addAccount(int accNo, String name) {
        accounts.put(accNo, name);
        System.out.println("Account added successfully.");
        System.out.println("Account No: " + accNo + " -> " + name);
    }

    void getCustomer(int accNo) {
        if (accounts.containsKey(accNo))
            System.out.println("Customer Name: " + accounts.get(accNo));
        else
            System.out.println("Account not found.");
    }

    void displayAll() {
        System.out.println("All Accounts: " + accounts);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        q3 bank = new q3();
        int choice;

        do {
            System.out.println("\n1. Add Account");
            System.out.println("2. Get Customer Name");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account No: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();
                    bank.addAccount(accNo, name);
                    break;

                case 2:
                    System.out.print("Enter Account No: ");
                    bank.getCustomer(sc.nextInt());
                    break;

                case 3:
                    bank.displayAll();
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

