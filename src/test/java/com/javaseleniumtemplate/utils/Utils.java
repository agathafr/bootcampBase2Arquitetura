package com.javaseleniumtemplate.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//import org.apache.commons.io.FileUtils;
//import org.testng.ITestResult;

public class Utils {

    public static String getNowDate(String mask) {
        DateFormat dateFormat = new SimpleDateFormat(mask);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getFileContent(String filePath) {
        BufferedReader br = null;
        StringBuilder sb = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
