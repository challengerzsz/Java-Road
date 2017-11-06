import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ReadFile {
    public static void main(String[] args) throws IOException{
        try (
                //创建文件输入流
                FileInputStream fis = new FileInputStream("e:\\Java-Road\\IO\\src\\ReadFile.java");
                //创建一个FileChannel
                FileChannel fcin = fis.getChannel()) {
            //定义一个ByteBuffer对象
            ByteBuffer buffer = ByteBuffer.allocate(256);
            //将FileChannel中的数据放入ByteBuffer中
            while (fcin.read(buffer) != -1) {
                //锁定Buffer的空白区
                buffer.flip();
                //创建Charset对象
                Charset charset = Charset.forName("utf-8");
                //创建解码器对象
                CharsetDecoder decoder = charset.newDecoder();
                //将ByteBuffer的内容转码
                CharBuffer charbuff = decoder.decode(buffer);
                System.out.println(charbuff);
                //将Buffer初始化，为下一次读取数据做准备
                buffer.clear();
            }
        }
    }
}
