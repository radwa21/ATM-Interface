import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Create user objects and add them to the ATM
        USER user1 = new USER("123456", "1234", 1000.0);
        USER user2 = new USER("654321", "4321", 500.0);

        ATM atm = new ATM();
        atm.addNewUser(user1);
        atm.addNewUser(user2);

        // Start the ATM
        atm.start();
    }
}