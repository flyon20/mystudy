package javaIO;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
class test{
    @Test
    public void s(){
        System.out.println("1");
    }
}
public class TCPser {
    @Test
    public void testSocket(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            InetAddress id = InetAddress.getByName("1.14.108.47");
            socket = new Socket(id,8080);
            os = socket.getOutputStream();
            fis = new FileInputStream(new File("t.png"));

            byte buffer []= new byte[1024];
            int len;
            while ((len = fis.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
            //关闭传输
            socket.shutdownOutput();
            //接收服务端信息
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte but[] = new byte[5];
            while ((len = is.read(but))!=-1){
                baos.write(but,0,len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void testServerSocket(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(9090);
            socket = ss.accept();
            is = socket.getInputStream();

            fos = new FileOutputStream(new File("t1.png"));

            byte buffer []= new byte[1024];
            int len;
            while ((len = is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            System.out.println("OK！收到");
            os = socket.getOutputStream();
            os.write("图片收到".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
