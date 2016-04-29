package edu.kpi.model;

import javax.persistence.*;

/**
 * Created by Abrasha on 31-Mar-16.
 */
@Entity
@Table
public class Town {

    private Integer id;
    private String name;
    private Region region;

    public Town() {

    }

    public Town(String name, Region region) {

        this.name = name;
        this.region = region;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
