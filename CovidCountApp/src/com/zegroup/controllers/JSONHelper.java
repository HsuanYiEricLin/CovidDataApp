package com.zegroup.controllers;

import com.zegroup.models.CSVModel;
import com.zegroup.models.SupportedCountries;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

public class JSONHelper {
    public void parseJSONToModel(String rawJSON, ArrayList<CSVModel> modelList) throws ParseException {
        JSONParser parse = new JSONParser();
        JSONArray json = (JSONArray) parse.parse(rawJSON);

        for (Object o : json) {
            JSONObject obj = (JSONObject) o;
            CSVModel model = new CSVModel((obj.get("Date").toString()),
                    obj.get("Country").toString(),
                    (long) obj.get("Confirmed"),
                    (long) obj.get("Deaths"),
                    (long) obj.get("Recovered"),
                    (long) obj.get("Active"));

            modelList.add(model);
        }
    }

    public void parseCountriesJSON(String rawCountriesJSON, ArrayList<SupportedCountries> countryList) throws ParseException {
        JSONParser parse = new JSONParser();
        JSONArray json = (JSONArray) parse.parse(rawCountriesJSON);

        for (Object o : json) {
            JSONObject obj = (JSONObject) o;
            SupportedCountries model = new SupportedCountries(obj.get("Country").toString(),
                    obj.get("Slug").toString());

            countryList.add(model);
        }

    }
}
