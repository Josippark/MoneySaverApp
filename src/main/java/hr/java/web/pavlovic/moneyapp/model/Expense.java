package hr.java.web.pavlovic.moneyapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message="You must enter some item!")
    private String name;

    @NotNull(message = "Cost cant be null")
    @Range(min=0, message = "Cost cant be in minus")
    private Integer cost;

    @NotNull(message="You must enter what kind of expense this item is!")
    @Enumerated(EnumType.STRING)
    private ExpenseType expenseType;

    @ManyToOne
    @JoinColumn(name = "WALLET_ID", referencedColumnName = "WALLET_ID")
    private Wallet wallet;

    public Expense(@NotEmpty(message = "You must enter some item!") String name, @NotNull(message = "Cost cant be null") @Range(min = 0, message = "Cost cant be in minus") Integer cost) {
        this.name = name;
        this.cost = cost;
    }

    public Expense(@NotEmpty(message = "You must enter some item!") String name, @NotNull(message = "Cost cant be null") @Range(min = 0, message = "Cost cant be in minus") Integer cost, @NotNull(message = "You must enter what kind of expense this item is!") ExpenseType expenseType) {
        this.name = name;
        this.cost = cost;
        this.expenseType = expenseType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Objects.equals(id, expense.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
