package edu.kpi.dto;

import edu.kpi.model.Notary;
import edu.kpi.model.Person;
import edu.kpi.model.Property;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

/**
 * @author Andrii Abramov on 20-May-16.
 */
public class NewRegistryDto {

    private Integer number;
    private Integer numberInActionList;
    private String series;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate irrevocabilty; // null if not irrevocable // TODO !!
    private Person principal;
    private Set<Person> confs;
    private Notary notary;
    private Property property;
    private String other;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumberInActionList() {
        return numberInActionList;
    }

    public void setNumberInActionList(Integer numberInActionList) {
        this.numberInActionList = numberInActionList;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getIrrevocabilty() {
        return irrevocabilty;
    }

    public void setIrrevocabilty(LocalDate irrevocabilty) {
        this.irrevocabilty = irrevocabilty;
    }

    public Person getPrincipal() {
        return principal;
    }

    public void setPrincipal(Person principal) {
        this.principal = principal;
    }

    public Set<Person> getConfs() {
        return confs;
    }

    public void setConfs(Set<Person> confs) {
        this.confs = confs;
    }

    public Notary getNotary() {
        return notary;
    }

    public void setNotary(Notary notary) {
        this.notary = notary;
    }

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
