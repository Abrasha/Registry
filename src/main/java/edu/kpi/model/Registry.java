package edu.kpi.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Abrasha on 31-Mar-16.
 */
@Entity
public class Registry {

    private int id;
    private int number; // TODO
    private int numberInActionList;
    private String series;
    private Date date;
    private Date irrevocability; // null if not irrevocable
    private Notary notary;
    private Person principal;
    private List<Person> confidants;
    private Property property;
    private String other;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Column
    public int getNumberInActionList() {
        return numberInActionList;
    }

    public void setNumberInActionList(int numberInActionList) {
        this.numberInActionList = numberInActionList;
    }

    @Column
    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @Column
    @Temporal(value = TemporalType.DATE)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column
    @Temporal(TemporalType.DATE)
    public Date getIrrevocability() {
        return irrevocability;
    }

    public void setIrrevocability(Date irrevocability) {
        this.irrevocability = irrevocability;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    public Notary getNotary() {
        return notary;
    }

    public void setNotary(Notary notary) {
        this.notary = notary;
    }

    // TODO
    @OneToOne
    public Person getPrincipal() {
        return principal;
    }

    public void setPrincipal(Person principal) {
        this.principal = principal;
    }

    @OneToMany
    public List<Person> getConfidants() {
        return confidants;
    }

    public void setConfidants(List<Person> confidants) {
        this.confidants = confidants;
    }

    @ManyToOne
    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
