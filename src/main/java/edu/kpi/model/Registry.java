package edu.kpi.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by Abrasha on 31-Mar-16.
 */
@Entity
public class Registry {

    private Integer id;
    private Integer number; // TODO
    private Integer numberInActionList;
    private String series;
    private LocalDate date;
    private Date irrevocability; // null if not irrevocable // TODO !!
    private Notary notary;
    private Person principal;
    private List<Person> confidants;
    private Property property;
    private String other;

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Column
    public Integer getNumberInActionList() {
        return numberInActionList;
    }

    public void setNumberInActionList(Integer numberInActionList) {
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
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column
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
