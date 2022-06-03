package javaIO;

import org.junit.Test;

import java.io.*;

//缓冲流，同节点流
public class Buffered {
    @Test
    public void testBuffered(){
        BufferedInputStream bui = null;
        BufferedOutputStream buo = null;
        try {
            bui = new BufferedInputStream(new FileInputStream(new File("D:\\test\\1.mp4")));
            buo = new BufferedOutputStream(new FileOutputStream(new File("D:\\test\\2.mp4")));

            byte cbuf[] = new byte[1024];
            int len;
            while ((len = bui.read(cbuf))!=-1){
                buo.write(cbuf,0,len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bui.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                buo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
