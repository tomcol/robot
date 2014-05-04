package com.tomcdev.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileUtils {
    public static String readFileAsString(String filePath) throws java.io.IOException{
        StringBuffer fileData = new StringBuffer(1000);
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            buf = new char[1024];
        }
        reader.close();
        return fileData.toString();
    }  
    
    public static String generateUniqueFileName(String directory, String fileName) {
    	int prefix = 0;
    	final String initialName = fileName;
    	while ((new File(directory + "/" + fileName)).exists())
    	fileName = (++prefix) + "_" + initialName;
    	return fileName;
    }
}
