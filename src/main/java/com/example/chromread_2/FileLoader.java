package com.example.chromread_2;/*
 *
 * load file and transform it into string
 * determine the way of array searching
 *
 *  */


import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileLoader {

    private FileReader loadedFile;

    private String expName;


    public String getDataFromFile(String path) {
        String stringFromFile = "";
        String fileExtension = "";
        byte[] byteFromFile = "".getBytes();
        try {
            byteFromFile = Files.readAllBytes(Paths.get(path));
            if (byteFromFile == null)  {
                throw new Exception("File cannot be read as text");
            }
            stringFromFile = new String(byteFromFile);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Please check the file name");
            stringFromFile = "";
        }
        return stringFromFile;

    }

    public String getExtension(String path) {
        String extansion = "";
        Pattern pattern = Pattern.compile(".*\\.([a-zA-Z]+)");
        Matcher matcher = pattern.matcher(path);
        if (matcher.find()) {
            extansion = matcher.group(1);
        }
        return extansion;
    }


}
