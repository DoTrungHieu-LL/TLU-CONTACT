package com.tlu.contact.model;

import java.io.Serializable;

/**
 * Model class representing a staff member
 */
public class Staff implements Serializable {
    private long id;
    private String name;
    private String position;
    private String phoneNumber;
    private String email;
    private String unit;
    private String office;
    private String imageUrl;

    public Staff(long id, String name, String position, String phoneNumber, String email,
                 String unit, String office, String imageUrl) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.unit = unit;
        this.office = office;
        this.imageUrl = imageUrl;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
