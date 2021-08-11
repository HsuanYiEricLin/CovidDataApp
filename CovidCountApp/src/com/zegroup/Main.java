package com.zegroup;

import com.zegroup.controllers.CovidDataApp;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        CovidDataApp app = new CovidDataApp(args);
    }
}

// https://code.google.com/archive/p/json-simple/downloads