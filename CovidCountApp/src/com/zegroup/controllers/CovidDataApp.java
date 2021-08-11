package com.zegroup.controllers;

import com.zegroup.models.CSVModel;
import com.zegroup.models.SummaryModel;
import com.zegroup.models.SupportedCountries;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class CovidDataApp {
    URLHelper urlHelper = new URLHelper();
    APIHelper apiHelper = new APIHelper();
    CSVHelper csvHelper = new CSVHelper();
    JSONHelper jsonHelper = new JSONHelper();
    CalculationHelper calculationHelper = new CalculationHelper();
    ValidationHelper validationHelper = new ValidationHelper();
    ArrayList<CSVModel> modelList = new ArrayList<>();
    ArrayList<SupportedCountries> countryList = new ArrayList<>();
    ArrayList<SummaryModel> summaryModelList = new ArrayList<>();
    ArrayList<String> givenCountries = new ArrayList<>();

    public CovidDataApp(String[] args) throws IOException, ParseException {
        validationHelper.validateNumberOfArguments(args);

        if (args.length == 0) {

            URL urlDefault1 = urlHelper.constructURLforCountryLastWeek("canada");
            URL urlDefault2 = urlHelper.constructURLforCountryLastWeek("south-africa");
            givenCountries.add("canada");
            givenCountries.add("south-africa");

            String rawJSON = apiHelper.getDataWithURL(urlDefault1);
            jsonHelper.parseJSONToModel(rawJSON, modelList);
            String rawJSON2 = apiHelper.getDataWithURL(urlDefault2);
            jsonHelper.parseJSONToModel(rawJSON2, modelList);

        }
        else{
            String date1 = "";
            String date2 = "";
            boolean date1Exist = false;
            boolean date2Exist = false;

            URL url = urlHelper.constructURLforSupportedCountries();
            String rawCountriesJSON = apiHelper.getDataWithURL(url);
            jsonHelper.parseCountriesJSON(rawCountriesJSON, countryList);

            // validating input arguments
            for(String arg: args){
                if(validationHelper.validateCountryIsSupported(arg, countryList)){
                    givenCountries.add(arg);
                }
                else{
                    if(validationHelper.validateDateFormat(arg)){
                        if(!date1Exist) {
                            date1 = arg;
                            date1Exist = true;
                        }
                        else{
                            date2 = arg;
                            date2Exist = true;
                        }
                    }
                }
            }

            // perform API requests
            if(validationHelper.validateNumberOfCountries(givenCountries)){
                if(date1Exist && date2Exist){
                    for ( String country : givenCountries){
                        URL getURL = urlHelper.constructURLforCountryGivenTime(country, date1, date2);
                        String rawJSON = apiHelper.getDataWithURL(getURL);
                        jsonHelper.parseJSONToModel(rawJSON, modelList);
                    }
                }
                else{
                    for ( String country : givenCountries ){
                        URL getURL = urlHelper.constructURLforCountryLastWeek(country);
                        String rawJSON = apiHelper.getDataWithURL(getURL);
                        jsonHelper.parseJSONToModel(rawJSON, modelList);
                    }
                }
            }
            else{
                for (int i = 0; i < 4; i++){
                    URL getURL = urlHelper.constructURLforCountryLastWeek(givenCountries.get(i));
                    String rawJSON = apiHelper.getDataWithURL(getURL);
                    jsonHelper.parseJSONToModel(rawJSON, modelList);
                }
            }

        }

        // group + sort before export CSV files
        csvHelper.sortModels(modelList);
        calculationHelper.calculateNewCases(modelList);
        calculationHelper.calculateCountryConfirmedCases(modelList, summaryModelList);
        csvHelper.exportCSV(modelList);
        csvHelper.exportSummaryReport(summaryModelList);
    }
}
