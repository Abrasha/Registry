package edu.kpi.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Abrasha on 31-Mar-16.
 */
@Entity
public class Notary {

    public enum NotaryType {
        STATE, PRIVATE
    }

    private int id;
    private NotaryType notaryType;
    private Town town;
    private String organisation;
    private String info;
    private List<Registry> registries;

    public Notary(NotaryType notaryType, Town town, String organisation, String info) {
        this.notaryType = notaryType;
        this.town = town;
        this.organisation = organisation;
        this.info = info;
    }

    public Notary() {

    }

    @OneToMany(mappedBy = "notary")
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

    @Enumerated
    public NotaryType getNotaryType() {
        return notaryType;
    }

    public void setNotaryType(NotaryType notaryType) {
        this.notaryType = notaryType;
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
