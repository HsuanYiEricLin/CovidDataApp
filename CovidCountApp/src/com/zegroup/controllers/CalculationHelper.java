package com.zegroup.controllers;

import com.zegroup.models.CSVModel;
import com.zegroup.models.SummaryModel;

import java.util.ArrayList;

// A helper class to perform calculations
public class CalculationHelper {
    private long total;
    private long max;
    private long min;
    private int days;
    private String currentCountry;

    public void calculateNewCases(ArrayList<CSVModel> modelList) {

        for (int i = 0; i < modelList.size()-1; i++) {
            CSVModel model = modelList.get(i);
            String modelCountry = model.getCountry();
            long modelCaseCount = model.getConfirmed();

            CSVModel model1 = modelList.get(i+1);
            String modelCountry1 = model1.getCountry();
            long modelCaseCount1 = model1.getConfirmed();

            if (modelCountry.equalsIgnoreCase(modelCountry1)) {
                if (modelCaseCount >= modelCaseCount1) {
                    model1.setNewCases(0);
                } else {
                    model1.setNewCases(modelCaseCount1 - modelCaseCount);
                }
            }
        }

    }

    public void calculateCountryConfirmedCases(ArrayList<CSVModel> modelList,
                                               ArrayList<SummaryModel> summaryModelList) {

        boolean iniFlag = true;
        currentCountry = "";
        for (CSVModel model : modelList) {
            if (!model.getCountry().equalsIgnoreCase(currentCountry)) {
                if(!iniFlag) {
                    SummaryModel summaryModel = new SummaryModel(currentCountry, max, min, total, days);
                    summaryModelList.add(summaryModel);
                }
                currentCountry = model.getCountry();
                total = model.getConfirmed();
                max = model.getConfirmed();
                min = model.getConfirmed();
                days = 1;
                iniFlag = false;
            } else {
                total = total + model.getConfirmed();
                max = Math.max(model.getConfirmed(), max);
                min = Math.min(model.getConfirmed(), min);
                days ++;
            }
        }
        SummaryModel summaryModel = new SummaryModel(currentCountry, max, min, total, days);
        summaryModelList.add(summaryModel);
    }
}
