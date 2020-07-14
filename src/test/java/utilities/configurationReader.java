package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class configurationReader {

    // create properties object
    // get the path, store it to String
    // to open the file, use FileInputStream class object, pass the path to parameter
    // then use object of properties class and call load() method pass file to parameter load(file)
    // close the file

   private static Properties properties = new Properties();

   // runs once before everything
   static {
       String path = "configuration.properties"; // or C:\Users\meamj\IdeaProjects\My_2020_TestNGSeleniumProject\configuration.properties
    try {
        FileInputStream file = new FileInputStream(path);
        properties.load(file);
        file.close();
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Properties file not found!");
    }
   }

   public static String getProperty(String keyWord){
       return properties.getProperty(keyWord);
   }

}
