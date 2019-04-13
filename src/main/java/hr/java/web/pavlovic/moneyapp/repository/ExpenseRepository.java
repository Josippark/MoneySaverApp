package hr.java.web.pavlovic.moneyapp.repository;

import hr.java.web.pavlovic.moneyapp.model.Expense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense,Long> {
}
