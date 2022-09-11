package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader =  new BufferedReader(new java.io.FileReader(file))) {
            String string = reader.readLine();
            while (string != null) {
                stringBuilder.append(string).append("\n");
                string = reader.readLine();
            }

        } catch (IOException e) {}

        String[] everything = stringBuilder.toString().split("\n");
        Map<String, String> profileMap = new HashMap();

        for (String line: everything) {
            String[] pair = line.split(":");
            profileMap.put(pair[0], pair[1]);
        }

        return new Profile(
                profileMap.get("Name"),
                Integer.parseInt(profileMap.get("Age")),
                profileMap.get("Email"),
                Long.parseLong(profileMap.get("Phone"))
        );
    }
}
