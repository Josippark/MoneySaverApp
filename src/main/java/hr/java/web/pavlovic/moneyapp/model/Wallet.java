package hr.java.web.pavlovic.moneyapp.model;

import lombok.Data;

@Data
public class Wallet {

    private String walletName;
    private WalletType walletType;
    private int balance;

    public enum WalletType {

        ŽIRO, TEKUĆI, DEVIZNI
    }

    public Wallet() {
    }

    public Wallet(String walletName, WalletType walletType, int balance) {
        this.walletName = walletName;
        this.walletType = walletType;
        this.balance = balance;
    }

}
