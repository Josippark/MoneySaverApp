package hr.java.web.pavlovic.moneyapp.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class Expense {

    @NotEmpty(message="You must enter some item!")
    private String name;
    @NotNull(message = "Cost cant be null")
    @Range(min=0, message = "Cost cant be in minus")
    private Integer cost;
    @NotNull(message="You must enter what kind of expense this item is!")
    private ExpenseType expenseType;

    private List<Wallet> wallets = new ArrayList<>();


}
