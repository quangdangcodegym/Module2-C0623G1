package iotextfile;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IOTextMain {
    public static void main(String[] args) throws Exception {


//        System.out.println((char) fileReader.read());
//        System.out.println((char) fileReader.read());

        /**
        List<Integer> list = readFile("numbers.txt");
        int total = 0;
        for (Integer v : list) {
            total += v;
        }
        list.add(total);

        writeFile(list, "numbers.txt");

         **/

        writeFileBufferWriter(Arrays.asList(5,1,4), "numbers.txt");
    }

    public static void writeFile(List<Integer> numbers, String fileName) throws IOException {

        File fileNumbers = new File(fileName);

        FileWriter fileWriter = new FileWriter(fileNumbers);   // throw new IOException

        for (Integer s : numbers) {
            fileWriter.write(String.valueOf(s) + "\n");
        }

//        fileWriter.close();
    }

    public static void writeFileBufferWriter(List<Integer> numbers, String fileName) throws IOException {
        File fileNumbers = new File(fileName);
        FileWriter fileWriter = new FileWriter(fileNumbers);


        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Integer s : numbers) {
            fileWriter.write(String.valueOf(s) + "\n");
        }

        bufferedWriter.flush();

    }

    public static List<Integer>  readFile(String fileName) throws IOException {
        List<Integer> list = new ArrayList<>();


        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            list.add(Integer.parseInt(line));
        }
        bufferedReader.close();

        return list;
    }





    //

    public static void chia0(int a, int b) throws Exception {
        if (b == 0) {
            throw new Exception("LOI CHIA 0");
        }
    }

    public void basicFileWriter()  throws Exception {
        List<String> names = Arrays.asList("Quang", "Doan", "Long");
        File fileBook = new File("book.txt");

        FileWriter fileWriter = new FileWriter(fileBook, true);   // throw new IOException

        char[] cbuf = {'A', 'B', 'C'};
        fileWriter.write(cbuf);

        for (String s : names) {
            fileWriter.write(s);
        }

        fileWriter.close();
    }
}
