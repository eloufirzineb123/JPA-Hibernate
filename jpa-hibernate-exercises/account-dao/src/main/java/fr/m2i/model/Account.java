package fr.m2i.model;

import fr.m2i.exception.AccountDaoException;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "creation_time", nullable = false)
    private LocalDateTime creationTime;

    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.ZERO.setScale(2);    

    public void copy(Account accountData) throws AccountDaoException {
         if (accountData.balance == null || accountData.birthday == null || accountData.creationTime == null || accountData.email == null || accountData.firstName == null || accountData.gender == null || accountData.id == null || accountData.lastName == null) {
            throw new AccountDaoException("", new Exception());
        }
        this.balance = accountData.balance;
        this.birthday = accountData.birthday;
        this.creationTime = accountData.creationTime;
        this.email = accountData.email;
        this.firstName = accountData.firstName;
        this.gender = accountData.gender;
        this.id = accountData.id;
        this.lastName = accountData.lastName;
    }
}