package MyTests.Day_6_30_2020;

import org.testng.annotations.Test;
import utilities.configurationReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readingFromProperties {
    @Test
    public void reading_properties_file() throws IOException {
        // we use properties class to be able to read data from properties file
        Properties properties = new Properties();

        // first we need the path of the file
        String path = "configuration.properties"; // or C:\Users\meamj\IdeaProjects\My_2020_TestNGSeleniumProject\configuration.properties
        FileInputStream file = new FileInputStream(path);

        properties.load(file);
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));


    }

    @Test
    public void configurationReaderUtility(){
        String browser = configurationReader.getProperty("browser");
        System.out.println("browser = "+browser);
    }
}
