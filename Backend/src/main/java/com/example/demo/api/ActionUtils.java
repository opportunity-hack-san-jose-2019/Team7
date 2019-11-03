package com.example.demo.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.model.Task;
import com.example.demo.model.TaskRequest;


public class ActionUtils {

    public static String absolutePath = "src/main/DataLayer/";
    public static boolean persistData(String callee, String fileToWrite)  {
        boolean isOpSuccessful = false;
        final String path = absolutePath+callee+".txt";

        try{
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(path, true));
            out.write(fileToWrite+"\n");

            out.close();
            // open a file in the append mode
            //
        }catch (Exception e){
      System.out.println(e);
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



    public static Task taskMapper(TaskRequest taskRequest){
        return null;
    }
}
