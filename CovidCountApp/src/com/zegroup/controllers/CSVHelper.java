package com.zegroup.controllers;

import com.zegroup.models.CSVModel;
import com.zegroup.models.SummaryModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CSVHelper {
    public void sortModels(ArrayList<CSVModel> modelList) {
        Collections.sort(modelList, new Comparator<CSVModel>() {
            @Override
            public int compare(CSVModel o1, CSVModel o2) {
                if (o1.getCountry().compareTo(o2.getCountry()) == 0) {
                    return o1.getDate().compareTo(o2.getDate());
                } else {
                    return o1.getCountry().compareTo(o2.getCountry());
                }
            }
        });
    }

    public void exportCSV(ArrayList<CSVModel> modelList) {
        try (PrintWriter writer = new PrintWriter(new File("CovidData.csv"))) {

            // Build headers
            StringBuilder sb = new StringBuilder();
            sb.append("Date");
            sb.append(',');
            sb.append("Country");
            sb.append(',');
            sb.append("Confirmed");
            sb.append(',');
            sb.append("Death");
            sb.append(',');
            sb.append("Recovered");
            sb.append(',');
            sb.append("Active");
            sb.append(',');
            sb.append("New Cases");
            sb.append('\n');

            for (CSVModel model: modelList){
                sb.append(model.getDate());
                sb.append(',');
                sb.append(model.getCountry());
                sb.append(',');
                sb.append(model.getConfirmed());
                sb.append(',');
                sb.append(model.getDeaths());
                sb.append(',');
                sb.append(model.getRecovered());
                sb.append(',');
                sb.append(model.getActive());
                sb.append(',');
                sb.append(model.getNewCases());
                sb.append('\n');
            }

            writer.write(sb.toString());

        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public void exportSummaryReport(ArrayList<SummaryModel> modelList) {
        try (PrintWriter writer = new PrintWriter(new File("SummaryReport.csv"))) {

            // Build headers
            StringBuilder sb = new StringBuilder();
            sb.append("Country");
            sb.append(',');
            sb.append("Max Confirmed");
            sb.append(',');
            sb.append("Min Confirmed");
            sb.append(',');
            sb.append("Average Confirmed");
            sb.append('\n');

            for (SummaryModel model: modelList){
                sb.append(model.getCountry());
                sb.append(',');
                sb.append(model.getMaxConfirmed());
                sb.append(',');
                sb.append(model.getMinConfirmed());
                sb.append(',');
                sb.append(model.getAverageConfirmed());
                sb.append('\n');
            }

            writer.write(sb.toString());

        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
