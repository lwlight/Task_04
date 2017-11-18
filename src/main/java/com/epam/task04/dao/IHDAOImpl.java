package com.epam.task04.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IHDAOImpl implements IHDAO {
    @Override
    public String readFullTextValue() {
        String fullTextValue = readTextFromFile();
        return fullTextValue;
    }

    private String readTextFromFile(){
        try(InputStream fis = IHDAOImpl.class.getClassLoader().getResourceAsStream("Text.txt");
            BufferedReader bfr = new BufferedReader(new InputStreamReader(fis))){
            String totalText = "";
            String readed = "";

            while ((readed = bfr.readLine()) != null) {
                totalText += (readed + "\n");
            }
            return totalText.trim();
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
