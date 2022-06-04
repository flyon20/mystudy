package javaIO;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPfile {
    @Test
    public void testSocket(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            InetAddress id = InetAddress.getByName("192.168.56.1");
            socket = new Socket(id,9090);
            os = socket.getOutputStream();
            fis = new FileInputStream(new File("t.png"));

            byte buffer []= new byte[1024];
            int len;
            while ((len = fis.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
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
        }
    }
    @Test
    public void testServerSocket(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fis = null;
        try {
            ss = new ServerSocket(9090);
            socket = ss.accept();
            is = socket.getInputStream();

            fis = new FileOutputStream(new File("t1.png"));

            byte buffer []= new byte[1024];
            int len;
            while ((len = is.read(buffer))!=-1){
                fis.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
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
        }
    }

}
