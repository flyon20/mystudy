package javaIO;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP {
    @Test
    public void testSocket(){
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress id = InetAddress.getByName("192.168.56.1");
            socket = new Socket(id,8899);

            os = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.write("hello,world!".getBytes());
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
        Socket socket = null;
        InputStream is = null;
        ServerSocket ss = null;
        ByteArrayOutputStream baos = null;
        try {
             ss = new ServerSocket(8899);
            socket = ss.accept();
            is = socket.getInputStream();

            baos = new ByteArrayOutputStream();
            byte buffer [] = new byte[5];
            int  len;
            while ((len = is.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
