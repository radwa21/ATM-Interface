import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class USER {

    private String userID;
    private String userPIN;
    double accountBalance;
    private List<String> trnsactionHistory ;

    public USER(String uId, String uPIN, double uAccountBalance){
        this.userID = uId;
        this.userPIN = uPIN;
        this.accountBalance = uAccountBalance;
        this.trnsactionHistory = new ArrayList<>();
    }

    public String getUserID(){
        return userID;
    }

    public String getUserPIN() {
        return userPIN;
    }

    public double getAccountBalance(){
        return accountBalance;
    }

    public List<String> getTrnsactionHistory() {
        return trnsactionHistory;
    }

    public void addToTransactionHistory(String transaction){
            trnsactionHistory.add(transaction);
    }

}

