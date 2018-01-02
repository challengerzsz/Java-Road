package util;

import data.Total;
import java.io.*;

public class FileUtil {
    public static final String TotalFileName = "Total.txt";

    /**
     * 存文件
     */
    public static boolean saveData(Object data) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(TotalFileName)
        )) {
            objectOutputStream.writeObject(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 读文件
     */
    public static Total readFromFile() {
        Total total = null;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(TotalFileName)
        )) {
            total = (Total) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            return total;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return total;
        }
        return total;
    }

}
