package com.example.demo.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.model.Task;


public class FileUtils {

    public static String absolutePath = "src/main/DataLayer/";

    public static boolean persistData(String callee, String fileToWrite, boolean append)  {
        boolean isOpSuccessful = false;
        final String path = absolutePath+callee+".txt";

        try{
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(path, append));
            out.write(fileToWrite+"\n");

            out.close();
        }catch (Exception e){
      return false;
        }
        return isOpSuccessful;
    }

    public static List<String> readData(String callee){
       List<String> resultData = new ArrayList<>();
        String path = absolutePath+callee+".txt";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();
            while(line != null) {
                System.out.println(line);

                resultData.add(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
      System.out.println(e);
            // exception handling
        } catch (IOException e) {
      System.out.println(e);
            // exception handling
        }

        return resultData;
    }

}
