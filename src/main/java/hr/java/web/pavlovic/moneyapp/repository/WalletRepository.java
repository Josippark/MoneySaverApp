package hr.java.web.pavlovic.moneyapp.repository;

import hr.java.web.pavlovic.moneyapp.model.Wallet;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends CrudRepository<Wallet,Long> {
}
