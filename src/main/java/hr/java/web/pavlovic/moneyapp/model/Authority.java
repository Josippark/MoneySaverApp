package hr.java.web.pavlovic.moneyapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name="authority")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AuthorityType name;


    public Authority(AuthorityType name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authority authority = (Authority) o;
        return Objects.equals(id, authority.id) &&
                name == authority.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
