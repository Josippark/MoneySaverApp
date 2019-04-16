package hr.java.web.pavlovic.moneyapp.repository;

import hr.java.web.pavlovic.moneyapp.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
}
