import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ATM {
    private List<USER> users;
    private USER currentUser;
    private Scanner scanner;

    public ATM() {
        this.users = new ArrayList<>();
        this.scanner = new Scanner(System.in);

    }

    public void addNewUser(USER newUser) {
        users.add(newUser);
    }

    public void start() {
        System.out.println(" Welcome To The ATM!");
        authenticateUser();

    }

    public void authenticateUser() {
        System.out.println("Enter your User ID");
        String userID = scanner.nextLine();
        System.out.println("Enter your User PIN");
        String userPIN = scanner.nextLine();

        for (USER user : users) {
            if (user.getUserID().equals(userID) && user.getUserPIN().equals(userPIN)) {
                currentUser = user;
                showMainMenu();
                return;
            }
        }
        System.out.println(" Invalid User ID or IPN, please try again!");
        authenticateUser();
    }

    public void showMainMenu() {
        System.out.println("\n Main Menu");
        System.out.println("1. View Account Balance ");
        System.out.println("2. Withdraw ");
        System.out.println("3. Deposit ");
        System.out.println("4. Transfer ");
        System.out.println("5. View Transaction History");
        System.out.println("6. Quit ");
        System.out.println("Enter your choice");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                viewAccountBalance();
                break;

            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                transfer();
                break;
            case 5:
                viewTransactionHistory();
                break;
            case 6:
                quit();
                break;
            default:
                System.out.println("invalid choice please try again");
                showMainMenu();
                break;

        }
    }

    public void viewAccountBalance() {
        double balance = currentUser.getAccountBalance();
        System.out.println("Account Balance: $" + balance);
        showMainMenu();

    }

    private void withdraw() {
        System.out.println("Enter the withdrawal amount: $");
        double withdrawalAmount = scanner.nextDouble();
        scanner.nextLine();

        if (withdrawalAmount <= 0) {
            System.out.println("Invalid withdrawal Amount, please try again ");
            withdraw();
            return;
        }
        if (withdrawalAmount > currentUser.getAccountBalance()) {
            System.out.println("Insufficient found, please try again ");
            withdraw();
            return;
        }
        currentUser.accountBalance -= withdrawalAmount;
        currentUser.addToTransactionHistory("Withdrawal: -$" + withdrawalAmount);
        System.out.println(" Withdrawal Successful. \n Remaining balance: $" + currentUser.getAccountBalance());
        showMainMenu();
    }

    private void deposit() {
        System.out.println("Enter the deposit amount: $");
        double depositAmount = scanner.nextDouble();
        scanner.nextLine();

        if (depositAmount <= 0) {
            System.out.println("Invalid withdrawal Amount, please try again ");
            withdraw();
            return;
        }

        currentUser.accountBalance += depositAmount;
        currentUser.addToTransactionHistory("Deposit: -$" + depositAmount);
        System.out.println(" Withdrawal Successful. \n Remaining balance: $" + currentUser.getAccountBalance());
        showMainMenu();
    }


    private void transfer() {
        System.out.println("Enter the recipient user ID");
        String recipientUserID = scanner.nextLine();
        USER recipient = null;
        for (USER user : users) {
            if (user.getUserID().equals(recipientUserID)) {
                recipient = user;
                break;
            }
        }
        if (recipient == null) {
            System.out.println("User not found please try again");
            transfer();
            return;
        }

        System.out.println(" Enter transfer amount: $");
        double transferAmount = scanner.nextDouble();
        scanner.nextLine();
        if (transferAmount <= 0) {
            System.out.println("Invalid transfer Amount, please try again ");
            transfer();
            return;
        }
        if (transferAmount > currentUser.getAccountBalance()) {
            System.out.println("Insufficient found, please try again ");
            transfer();
            return;
        }
        currentUser.accountBalance -= transferAmount;
        recipient.accountBalance += transferAmount;
        currentUser.addToTransactionHistory("Transfer to: " + recipient.getUserID() + " : -$" + transferAmount);
        recipient.addToTransactionHistory("Transfer from: " + currentUser.getUserID() + " : -$" + transferAmount);
        System.out.println(" transfer Successful. \n Remaining balance: $" + currentUser.getAccountBalance());
        showMainMenu();

    }


    public void viewTransactionHistory() {
        List<String> transactionHistory = currentUser.getTrnsactionHistory();
        if (transactionHistory.isEmpty()) {
            System.out.println(" No transaction history");
        } else {
            System.out.println(" Transaction History: ");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }

        }
        showMainMenu();
    }

    private void quit() {
        System.out.println("Thank you for using the ATM. Goodbye!");
        System.exit(0);
    }
}


