package org.sandrm.studyMaven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Refresh Maven!
 *
 * java -classpath .;./std-Maven-0.0.1-SNAPSHOT.jar org.sandrm.studyMaven.App
 * java -classpath .;std-Maven-0.0.1-SNAPSHOT.jar org.sandrm.studyMaven.App
 * java -cp std-Maven-0.0.1-SNAPSHOT.jar org.sandrm.studyMaven.App
 */
public class App {
	final static Logger logger = Logger.getLogger(App.class);
	
    public static void main( String[] args ){
        System.out.println( "App is running!" );
        System.out.println( "This is develop branch! v: 0.0.2.0-SNAPSHOT" );
        
    	Properties prop = new Properties();
    	InputStream input = null;
    	
    	logger.info("Test TC build #5: Feb 25");
    	
    	try {
			//input = new FileInputStream("config.properties");
    		//input = App.class.getResourceAsStream("//src//main//resources//config.properties");
    		
    		//Load a properties file from classpath
    		input = App.class.getClassLoader().getResourceAsStream("config.properties");
    		
    		
			prop.load(input);
			
			//System.out.println(prop.getProperty("param1"));
			//System.out.println(prop.getProperty("param2"));
			logger.info("Loaded param1: " + prop.getProperty("param1"));
			logger.info("Loaded param2: " + prop.getProperty("param2"));

			logger.info("Populate config.person.name: " + prop.getProperty("myapp.person.name"));
			logger.info("Populate config.person.lastname: " + prop.getProperty("myapp.person.lastname"));
			
			logger.info("Populate ENVNAME: " + prop.getProperty("ENVNAME"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
    
	private void nonStaticMethod(){
		//For non-static method, use this :
		//prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
	}

}
