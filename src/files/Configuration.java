package files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	
	public static Properties prop;
	public static String path=System.getProperty("user.dir")+"\\src\\files\\env.properties";
	public Configuration() {
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream(path);
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
