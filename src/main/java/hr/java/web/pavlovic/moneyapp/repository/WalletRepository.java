package hr.java.web.pavlovic.moneyapp.repository;

import hr.java.web.pavlovic.moneyapp.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Long> {
}
