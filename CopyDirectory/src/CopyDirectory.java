import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
class Copy {
    public void copyAll(String oldFilePath, String newFilePath) throws IOException{
        File oldFile = new File(oldFilePath);
        int hasRead;
        byte[] buf = new byte[1000];
        if (oldFile.exists() && oldFile.isDirectory()) {
            File newFile = new File(newFilePath);
            newFile.mkdir();
            File[] fileList = oldFile.listFiles();
            for (File tmp : fileList) {
                //tmp是文件
                if (tmp.isFile()) {
                    FileInputStream fileInputStream = new FileInputStream(tmp.getPath());
                    FileOutputStream fileOutputStream = new FileOutputStream(newFilePath + "\\" + tmp.getName());
                    while ((hasRead = fileInputStream.read()) > 0) {
                        fileOutputStream.write(buf, 0, hasRead);
                    }
                }
                else {
                    copyAll(oldFilePath + "\\" + tmp.getName(), newFilePath + "\\" + tmp.getName());
                }
            }
        } else {
            System.out.println("未找到指定文件夹，新建to目录失败");
            return;
        }
    }
}
public class CopyDirectory {
    public static void main(String[] args) throws IOException {
        String oldFilePath = "E:\\Java-Road\\IO";
        String newFilePath = "C:\\Users\\66490\\Desktop\\newIO";
        new Copy().copyAll(oldFilePath, newFilePath);
    }
}
