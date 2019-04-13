package hr.java.web.pavlovic.moneyapp.initialization;

import hr.java.web.pavlovic.moneyapp.model.*;
import hr.java.web.pavlovic.moneyapp.repository.AuthorityRepository;
import hr.java.web.pavlovic.moneyapp.repository.ExpenseRepository;
import hr.java.web.pavlovic.moneyapp.repository.UserRepository;
import hr.java.web.pavlovic.moneyapp.repository.WalletRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DbInit implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;
    private ExpenseRepository expenseRepository;
    private WalletRepository walletRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, AuthorityRepository authorityRepository, ExpenseRepository expenseRepository, WalletRepository walletRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.expenseRepository = expenseRepository;
        this.walletRepository = walletRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {

        this.userRepository.deleteAll();
        this.authorityRepository.deleteAll();
        this.walletRepository.deleteAll();
        this.expenseRepository.deleteAll();

        User user = new User("admin", passwordEncoder.encode("admin"), true);
        Authority authority = new Authority(AuthorityType.ADMIN);
        Wallet wallet = new Wallet(100,"noviNovcanik", WalletType.TEKUĆI);
        Expense expense = new Expense("pizza",20,ExpenseType.HRANA);

        user.getAuthorities().add(authority);
        wallet.getExpenses().add(expense);
        user.getWallets().add(wallet);

        userRepository.save(user);
        expenseRepository.save(expense);
        walletRepository.save(wallet);


    }

}