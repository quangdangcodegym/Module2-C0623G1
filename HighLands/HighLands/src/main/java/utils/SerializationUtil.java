package utils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class SerializationUtil {
    // đọc lên
    public static Object deserialize(String fileName) {
        Object obj = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println("Errors File: " + e.getMessage());
        }
        return obj;
    }
    // serialize the given object and save it to file

    // Ghi xuống file
    public static void serialize(Object obj, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            fos.close();
        } catch (Exception e) {
            System.out.println("Errors File: " + e.getMessage());
        }
    }
}
