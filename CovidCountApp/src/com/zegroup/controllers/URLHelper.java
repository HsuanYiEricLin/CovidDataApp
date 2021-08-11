package com.zegroup.controllers;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

/* A class that builds URLs */
public class URLHelper {
    final String baseURL = "https://api.covid19api.com/";
    final String summaryURL = baseURL + "summary";
    final String countryURL = baseURL + "country/";
    final String countriesURL = "countries";
    final String dateURL = "date/";
    final String fromURL = "?from=";
    final String toURL = "&to=";

    public URL constructURLforCountryLastWeek(String country) throws MalformedURLException {
        LocalDate now = LocalDate.now();
        LocalDate lastWeek = now.minusDays(6);
        String nowISO = now.toString() + "T00:00:00Z";
        String lastWeekISO = lastWeek.toString() + "T00:00:00Z";

        return new URL(  countryURL + country + fromURL + lastWeekISO + toURL + nowISO);
    }

    public URL constructURLforCountryGivenTime(String country, String start, String end) throws MalformedURLException {
        String startISO = start + "T00:00:00Z";
        String endISO = end + "T00:00:00Z";

        return new URL(  countryURL + country + fromURL + startISO + toURL + endISO);
    }

    public URL constructURLforSupportedCountries() throws MalformedURLException {
        return new URL( baseURL + countriesURL );
    }

}
