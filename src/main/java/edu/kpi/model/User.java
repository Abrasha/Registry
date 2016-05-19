package edu.kpi.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by Abrasha on 31-Mar-16.
 */

@Entity
@Table
@Component
@Scope("session")
public class User {
    public enum AccountType {
        ADMIN, USER
    }

    private Integer id;
    private String login;
    private String password;
    private AccountType accountType;

    public User() {
    }

    public User(String login, String password, AccountType accountType) {
        this.login = login;
        this.password = password;
        this.accountType = accountType;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(unique = true, nullable = false)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", accountType=" + accountType +
                '}';
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Enumerated(EnumType.ORDINAL)
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
