package com.votesimulation.impl.entities;

/**
 * Created by Anca on 23-Aug-15.
 */
public class VoteSection {
    private Integer id;
    private String city;
    private String street;
    private Integer number;

    public VoteSection() {
    }

    public VoteSection(Integer id, String city, String street, Integer number) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
