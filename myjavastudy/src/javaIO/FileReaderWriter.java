package javaIO;

import org.junit.Test;

import java.io.*;


public class FileReaderWriter {
    @Test//单元测试
    public void TestFileReader(){
        FileReader fir = null;
        try {
            File file = new File("hello.txt");
            fir = new FileReader(file);
            int data = fir.read();
            while(data != -1){
                System.out.println((char)data);
                data = fir.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fir != null)
                    fir.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
   @Test
    public void testFileReader(){
        FileReader fir = null;
       try {
           File file = new File("hello.txt");
           fir = new FileReader(file);
           char cubf[] = new char[5];
           int len;
           while ((len=fir.read(cubf))!=-1){
               //实现一
//               for(int i=0;i<len;i++)
//                   System.out.print(cubf[i]);
//
               //实现二
               String str = new String(cubf,0,len);
               System.out.print(str);
           }
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           try {
               if(fir != null)
                   fir.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }

   }
   @Test
   //不能处理图片
    public void testFileCopy(){
       FileReader fir = null;
       FileWriter fiw = null;
       try {
           File file1  = new File("hello.txt");
           File file2 = new File("hello1.txt");

           fir = new FileReader(file1);
           fiw = new FileWriter(file2);

           char [] cubf = new char[5];
           int len;
           while ((len = fir.read(cubf))!=-1){
               fiw.write(cubf,0,len);
           }
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           try {
               fir.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
           try {
               fiw.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }

   }

}
