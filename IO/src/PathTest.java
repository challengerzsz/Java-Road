import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    public static void main(String[] args) throws IOException{
        //以当前路径创建Path对象
        Path path = Paths.get(".");
        System.out.println("path里包含的路径数量" + path.getNameCount());
        System.out.println("path的根路径" + path.getRoot());
        //获取path的绝对路径
        Path absolutePath = path.toAbsolutePath();
        System.out.println(absolutePath);
        //获取绝对路径的根路径
        System.out.println("absolutePath的根路径" + absolutePath.getRoot());
        //获取绝对路径包含的路径数量
        System.out.println(absolutePath.getNameCount());
        System.out.println(absolutePath.getName(3));
        //以多个String来构建Path对象
        Path path1 = Paths.get("g:", "publish", "codes");
        System.out.println(path1);
    }
}
