import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class GetPostTest {
    public static String sendGet(String url, String param) {
        String result = "";
        String urlName = url + "?" + param;

        try {
            URL realUrl = new URL(url);
            //打开和URL连接
            URLConnection connection = realUrl.openConnection();
            //设置通用请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 600; Windows NT 5.1;" +
                    "SV1)");
            connection.connect();
            //获取所有响应的头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            for (String key : map.keySet()) {
                System.out.println(key + "->" + map.get(key));
            }

            try (//定义BufferedReader输入流来读取URL的响应
                 BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),
                         "utf-8"))) {
                String line;
                while ((line = in.readLine()) != null) {
                    result += "\n" + line;
                }

            } catch (Exception ex) {
                System.out.println("发送GET请求出现异常！" + ex);
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static String sentPost(String url, String param) {
        String result = "";
        try {
            URL rearUrl = new URL(url);
            //打开和Url之间的连接
            URLConnection connection = rearUrl.openConnection();
            //设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");

            //发送POST请求必须有如下两行代码
            connection.setDoOutput(true);
            connection.setDoInput(true);


            //获取URLConnection对象对应的输出流
            try (PrintStream out = new PrintStream(connection.getOutputStream())) {
                //发送请求参数
                out.print(param);
                //flush输出流的缓冲
                out.flush();
            }

            //定义BufferedReader输入流来读取URL的响应
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),
                    "utf-8"))) {
                String line;
                while ((line = in.readLine()) != null) {
                    result += "\n" + line;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        //发送GET请求
        String getResult = GetPostTest.sendGet("http://localhost:8080/ChallengeCup/Login", null);
        System.out.println(getResult);
        //发送POST请求
        String postResult = GetPostTest.sentPost("http://localhost:8080/ChallengeCup/Login",
                "userName=zsz&password=123456");
        System.out.println(postResult);
    }
}
