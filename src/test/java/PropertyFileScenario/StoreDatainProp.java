package PropertyFileScenario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class StoreDatainProp {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileOutputStream file = new FileOutputStream("C:\\Users\\ahmad\\IdeaProjects\\Selenium_Practice_new\\src\\test\\java\\Test.properties");
//        properties.setProperty("browser","firefox");
        properties.setProperty("time","firefox");
      properties.store(file,"Update");
    }
}
