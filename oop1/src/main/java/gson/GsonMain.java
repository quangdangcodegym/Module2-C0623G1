package gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class GsonMain {
    public static void main(String[] args) {


        /**
         Gson gson = new Gson();
        Rectangle rectangle = new Rectangle("RED", true, 5, 9);

        String jsonObj = gson.toJson(rectangle);

        System.out.println(jsonObj);

         String s = "{\"height\":9.0,\"width\":5.0,\"color\":\"RED\",\"filled\":true}";
         Rectangle rectangle = gson.fromJson(s, Rectangle.class);
         System.out.println(rectangle.showHang());

         try {
         FileReader fileReader = new FileReader("./data/products.json");
         Type REVIEW_TYPE = new TypeToken<List<Product>>() {
         }.getType();

         List<Rectangle> data = gson.fromJson(fileReader, REVIEW_TYPE);

         System.out.println(data);
         } catch (FileNotFoundException e) {
         }
         **/

        List<Rectangle> products = FileUtils.readData("./data/products.json");

        FileUtils.writeData(products, "./data/products1.json");
    }
}
