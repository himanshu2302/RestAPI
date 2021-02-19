package com.restapi.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

	public Properties prop;
	public BaseClass() {

		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream("C:\\Users\\Himanshu.Dubey\\eclipse-workspace\\RestAPITest\\src\\main\\java\\com\\restapi\\config\\config.properties");
			prop.load(file);;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
}
