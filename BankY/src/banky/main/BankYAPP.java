package banky.main;

import banky.model.Customer;
import banky.service.BankService;
import banky.util.DataPersistence;

import java.util.Map;
import java.util.Scanner;

public class BankYAPP {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        Map<String, Customer> customers = DataPersistence.loadData();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to BankY!");
        boolean running = true;

        while (running) {
            System.out.println("1. Create Customer");
            System.out.println("2. Create Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer Funds");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    bankService.createCustomer(name);
                    System.out.println("Customer created successfully.");
                    break;
                case 2:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    bankService.createAccount(customerName, accountNumber);
                    System.out.println("Account created successfully.");
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    String depositAccount = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (bankService.deposit(depositAccount, depositAmount)) {
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Deposit failed. Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    String withdrawAccount = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (bankService.withdraw(withdrawAccount, withdrawAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Withdrawal failed. Account not found or insufficient funds.");
                    }
                    break;
                case 5:
                    System.out.print("Enter from account number: ");
                    String fromAccount = scanner.nextLine();
                    System.out.print("Enter to account number: ");
                    String toAccount = scanner.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    if (bankService.transferFunds(fromAccount, toAccount, transferAmount)) {
                        System.out.println("Transfer successful.");
                    } else {
                        System.out.println("Transfer failed. Check account numbers or balance.");
                    }
                    break;
                case 6:
                    running = false;
                    DataPersistence.saveData(customers);
                    System.out.println("Data saved. Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
