package com.cg.shopping.utils;


import com.cg.shopping.model.IParseModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static <T> List<T> readData(String fileName, Class<T> clazz) {
        List<T> data = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                /**
                Object obj = null;
                if (clazz.getName().equals("User")) {
                    obj = new User();
                }
                if (clazz.getName().equals("Product")) {
                    obj = new Product();
                }
                 **/

                Object obj = clazz.newInstance();
                IParseModel<T> iParseModel = (IParseModel) obj;
                data.add(iParseModel.parse(line));
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return data;
    }


    public static <T> void writeData(String fileName, List<T> data){
        FileWriter fileWriter = null;
        try {
            File file = new File(fileName);
            fileWriter = new FileWriter(file);

            for (int i = 0; i < data.size(); i++) {
                fileWriter.write(data.get(i).toString());
                if (i != data.size() - 1) {
                    fileWriter.write("\n");
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }


}
