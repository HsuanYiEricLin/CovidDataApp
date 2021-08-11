package com.zegroup.controllers;

import com.zegroup.models.SupportedCountries;

import java.util.ArrayList;

/* A class to validate inputs */
public class ValidationHelper {
    private final int maxInput = 6;

    public void validateNumberOfArguments(String[] args){
        if( args.length >= 6 ) {
            throw new IllegalArgumentException("Too many arguments");
        }
    }

    public boolean validateCountryIsSupported(String arg, ArrayList<SupportedCountries> countryList) {
        for( SupportedCountries country : countryList){
            String supported = country.getCountry();
            String stripped = arg.trim().replace('-',' ');
            if(stripped.equalsIgnoreCase(supported) || supported.toLowerCase().contains(stripped)){
               return true;
            }
        }
        return false;
    }

    public boolean validateNumberOfCountries(ArrayList<String> givenCountries) {
        return givenCountries.size() <= 4;
    }

    public boolean validateDateFormat(String date) {
        return (date.matches("\\d{4}-\\d{2}-\\d{2}"));
    }
}
