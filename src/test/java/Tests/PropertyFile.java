package Tests;

import java.io.*;
import java.util.Properties;

public class PropertyFile {

    static Properties prop = new Properties();

    public static void main(String[] args) {
        getProperties();
        setProperties();
        getProperties();
    }

    public static void getProperties() {

        InputStream input;

        {
            try {
                input = new FileInputStream("C:\\AmazonAutomationTest\\src\\main\\resources\\config\\Config.properties");
                prop.load(input);
                String url = prop.getProperty("url");
                String browser = prop.getProperty("browser");
                System.out.println(browser);
                Test.browserName = browser;
                Test.url = url;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

        public static void setProperties() {
            try {
                OutputStream output = new FileOutputStream("C:\\AmazonAutomationTest\\src\\main\\resources\\config\\Config.properties");
                prop.setProperty("browser", "firefox");
                prop.store(output, "output stored");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }



