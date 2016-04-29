package edu.kpi.model;

import javax.persistence.*;

/**
 * Created by Abrasha on 31-Mar-16.
 */
@Entity
public class Person {

    public enum PersonType {
        INDIVIDUAL, ENTITY
    }

    private Integer id;
    private String code; // TODO
    private PersonType personType;
    private String name;
    private String other;

    public Person(String code, PersonType personType, String name, String other) {
        this.code = code;
        this.personType = personType;
        this.name = name;
        this.other = other;
    }

    public Person() {

    }

    @Id
    @GeneratedValue
    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Enumerated(EnumType.STRING)
    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
