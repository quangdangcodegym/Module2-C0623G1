package com.cg.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonUtils {
    public static <T> List<T> readData(String fileName){
        List<T> data = null;
        Gson gson = new Gson();
        try {
            FileReader fileReader = new FileReader(fileName);
            Type REVIEW_TYPE = new TypeToken<List<T>>() {
            }.getType();

            data = gson.fromJson(fileReader, REVIEW_TYPE);

            System.out.println(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void writeData(Object obj, String fileName) {
        Gson gson = new Gson();

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(gson.toJson(obj));

            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
