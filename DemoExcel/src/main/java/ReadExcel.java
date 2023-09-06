import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ReadExcel {
    public void writeData() {
        XSSFWorkbook workbook = new XSSFWorkbook();

//Create a blank sheet

        XSSFSheet sheet = workbook.createSheet("Employee Data");

//Prepare data to be written as an Object[]

        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[] {"ID", "NAME", "LASTNAME"});
        data.put("2", new Object[] {1, "Amit", "Shukla"});
        data.put("3", new Object[] {2, "Lokesh", "Gupta"});
        data.put("4", new Object[] {3, "John", "Adwards"});
        data.put("5", new Object[] {4, "Brian", "Schultz"});

//Iterate over data and write to sheet

        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }

//Write the workbook in file system

        try {
            FileOutputStream out = new FileOutputStream(new File("./data/howtodoinjava_demo.xlsx"));
            workbook.write(out);
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     Hướng dẫn gốc từ trang
    https://howtodoinjava.com/java/library/readingwriting-excel-files-in-java-poi-tutorial/

     Nhớ: tạo thư mục data trước
     Đọc thêm gợi ý về hàm đọc file dùng FOR: readDataUseFor();
     **/
    public void readData() {
        try {
            FileInputStream file = new FileInputStream(new File("./data/howtodoinjava_demo.xlsx"));

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {

                Row row = rowIterator.next();

                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();

                    //Check the cell type and format accordingly
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "t");
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "t");
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();
        } catch (FileNotFoundException fileNotFoundException) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void readDataUseFor(){
        try{

            FileInputStream file = new FileInputStream(new File("./data/howtodoinjava_demo.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Lặp qua các hàng (rows)
            for (Row row : sheet) {
                // Lặp qua các ô (cells) trong hàng
                for (Cell cell : row) {
                    // Đọc giá trị từ ô và in ra màn hình
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println(); // Xuống dòng sau mỗi hàng
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReadExcel excel = new ReadExcel();
//        readExcel.writeData();
        excel.readDataUseFor();
    }
}
