package edu.kpi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Abrasha on 31-Mar-16.
 */
@Entity
public class AccountType {

    private Integer id;
    private String typeName;

    public AccountType(String typeName) {
        this.typeName = typeName;
    }

    public AccountType() {

    }

    @Id
    @GeneratedValue
    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
