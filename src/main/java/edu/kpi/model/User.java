package edu.kpi.model;

import javax.persistence.*;

/**
 * Created by Abrasha on 31-Mar-16.
 */

@Entity
@Table
public class User {

    private int id;
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToOne
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
