package com.zegroup.models;

public class SupportedCountries {
    private String country;
    private String slug;
    private String IS02;

    public SupportedCountries(String country, String slug) {
        this.country = country;
        this.slug = slug;
    }

    public SupportedCountries(String country, String slug, String IS02) {
        this.country = country;
        this.slug = slug;
        this.IS02 = IS02;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getIS02() {
        return IS02;
    }

    public void setIS02(String IS02) {
        this.IS02 = IS02;
    }
}
