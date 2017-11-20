package com.epam.task04.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IhDaoImpl implements IhDao {
    private static final Logger LOGGER = LogManager.getLogger(IhDaoImpl.class.getName());
    @Override
    public String readFullTextValue() {
        String fullTextValue = readTextFromFile();
        return fullTextValue;
    }

    private String readTextFromFile(){
        try(InputStream fis = IhDaoImpl.class.getClassLoader().getResourceAsStream("Text.txt");
            BufferedReader bfr = new BufferedReader(new InputStreamReader(fis))){
            String totalText = "";
            String readed = "";

            while ((readed = bfr.readLine()) != null) {
                totalText += (readed + "\n");
            }

            return totalText.trim();
        } catch (IOException e){
            LOGGER.error("Fail to read from file");
            return null;
        }
    }
}
