package com.telran.oskar.utils;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public static Iterator<Object[]> registrationWithInvalidEmail() throws IOException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/negEmail.csv")));

        List<Object[]> list = new ArrayList<>();
        String line = reader.readLine();

        while (line != null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }
}
