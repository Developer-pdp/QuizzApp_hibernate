package uz.team_dev.properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DBProperty {
    private static final Properties property = new Properties();

    static {
        try {
            property.load(new FileReader("todoapp/src/main/resources/datasource.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return property.getProperty(key, key);
    }
}
