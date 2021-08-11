package com.zegroup.models;


public class CSVModel {
    private String date;
    private String country;
    private long confirmed;
    private long deaths;
    private long recovered;
    private long active;
    private long newCases;

    public CSVModel() {
    }

    public CSVModel(String date, String country, long confirmed, long deaths, long recovered, long active) {
        this.date = date;
        this.country = country;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
        this.active = active;
        this.newCases = 0;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(long confirmed) {
        this.confirmed = confirmed;
    }

    public long getDeaths() {
        return deaths;
    }

    public void setDeaths(long deaths) {
        this.deaths = deaths;
    }

    public long getRecovered() {
        return recovered;
    }

    public void setRecovered(long recovered) {
        this.recovered = recovered;
    }

    public long getActive() {
        return active;
    }

    public void setActive(long active) {
        this.active = active;
    }

    public long getNewCases() {
        return newCases;
    }

    public void setNewCases(long newCases) {
        this.newCases = newCases;
    }
}
