package edu.kpi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by Abrasha on 31-Mar-16.
 */
@Entity
public class Property {

    private int id;
    private int serialNumber;
    private int registrationNumber;
    private PropertyType propertyType;
    private String description;

    public Property(PropertyType propertyType, int serialNumber, int registrationNumber, String description) {
        this.propertyType = propertyType;
        this.serialNumber = serialNumber;
        this.registrationNumber = registrationNumber;
        this.description = description;
    }

    public Property() {
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
    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}