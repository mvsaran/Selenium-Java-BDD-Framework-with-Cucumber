package utilities;

import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	public class configReader {
	    private static Properties properties;

	    public static void loadProperties() {
	        try {
	            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
	            properties = new Properties();
	            properties.load(file);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static String getProperty(String key) {
	        return properties.getProperty(key);
	    }
	}

// This class reads configuration properties from a file.
