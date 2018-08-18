import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zeng
 * @Date: 2018/8/18 10:43
 */
public class TestStringPool {

    public static void main(String[] args) throws Throwable {
        List<String> list = new ArrayList<>();
        int i=0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }

    }
}
