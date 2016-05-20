package edu.kpi.dto;

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
    private String principalName;
    private Set<String> confs;
    private Integer notaryId;
    private Integer propertyRegNumber;
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

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public Set<String> getConfs() {
        return confs;
    }

    public void setConfs(Set<String> confs) {
        this.confs = confs;
    }

    public Integer getNotaryId() {
        return notaryId;
    }

    public void setNotaryId(Integer notaryId) {
        this.notaryId = notaryId;
    }

    public Integer getPropertyRegNumber() {
        return propertyRegNumber;
    }

    public void setPropertyRegNumber(Integer propertyRegNumber) {
        this.propertyRegNumber = propertyRegNumber;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
