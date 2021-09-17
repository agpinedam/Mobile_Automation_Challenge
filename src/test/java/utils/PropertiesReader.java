package utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static PropertiesReader propertiesReader;
    private String value;
    private String movieName;
    private String overview;

    private void readCredentials (int movieID) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(".\\src\\test\\resources\\movies.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        try {
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        value = properties.getProperty(String.valueOf(movieID));
        String[] splitValues = value.split("\n");
        movieName = splitValues[0];
        overview = splitValues[1];
    }

    public static PropertiesReader getInstance(int movieID){
        if(propertiesReader ==null){
            propertiesReader = new PropertiesReader();
            propertiesReader.readCredentials(movieID);
        }
        return propertiesReader;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getOverview() {
        return overview;
    }
}