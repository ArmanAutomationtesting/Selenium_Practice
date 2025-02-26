import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Test {

    public void test123() throws IOException {

        Properties prop1 = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ahmad\\IdeaProjects\\Selenium_Practice_new\\src\\test\\java\\Test.properties");
        prop1.load(fileInputStream);
        Map<String,Object> map = new HashMap<>();
        map.put("Employee-Name", prop1.getProperty("name"));
        map.put("Employee-Sal", prop1.getProperty("sal"));
        map.put("Dep", prop1.getProperty("dep"));

        System.out.println(map);
        Gson gson = new Gson();
        String gsonpay = gson.toJson(map);
        System.out.println(gsonpay);

    }

    public static void main(String[] args) throws IOException {
        Test test = new Test();
        test.test123();
    }

}
