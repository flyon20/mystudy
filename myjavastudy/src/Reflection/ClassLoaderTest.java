package Reflection;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderTest {
    @Test
    public void test() throws Exception {
        Properties por = new Properties();
        //获取配置文件，流方式获取
        //文件是在当前Moudle下
       //FileInputStream fis = new FileInputStream("jdbc.properties");

        // 获取配置文件，ClassLoader方式获取
        //文件是在当前src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");

        por.load(is);
        String user = por.getProperty("user");
        String password = por.getProperty("password");
        System.out.println("user="+user+" password="+password);
    }
}
