package hr.java.web.pavlovic.moneyapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wallets")
public class Wallet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WALLET_ID")
    private Long id;
    @Column(name = "WALLET_NAME")
    private String walletName;

    @Column(name = "WALLET_BALANCE")
    private int balance;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User user;

    @Enumerated(EnumType.STRING)
    private WalletType walletType;

    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL)
    private Set<Expense> expenses = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(id, wallet.id);
    }

    public Wallet(String walletName, int balance) {
        this.walletName = walletName;
        this.balance = balance;
    }

    public Wallet(int balance, String walletName, WalletType walletType) {
        this.balance = balance;
        this.walletName = walletName;
        this.walletType = walletType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", walletName='" + walletName + '\'' +
                ", balance=" + balance +
                ", user=" + user +
                ", walletType=" + walletType +
                '}';
    }
}
