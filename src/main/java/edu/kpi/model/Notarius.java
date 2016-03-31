package edu.kpi.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Abrasha on 31-Mar-16.
 */
@Entity
public class Notarius {

    private int id;
    private NotariusType notariusType;
    private Town town;
    private String organisation;
    private String info;
    private List<Registry> registries;

    public Notarius(NotariusType notariusType, Town town, String organisation, String info) {
        this.notariusType = notariusType;
        this.town = town;
        this.organisation = organisation;
        this.info = info;
    }

    public Notarius() {

    }

    //@OneToMany
    @Transient // TODO
    public List<Registry> getRegistries() {
        return registries;
    }

    public void setRegistries(List<Registry> registries) {
        this.registries = registries;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne
    public NotariusType getNotariusType() {

        return notariusType;
    }

    public void setNotariusType(NotariusType notariusType) {
        this.notariusType = notariusType;
    }

    @ManyToOne
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
