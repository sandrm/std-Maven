package org.sandrm.studyMaven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Refresh Maven!
 *
 * java -classpath .;./std-Maven-0.0.1-SNAPSHOT.jar org.sandrm.studyMaven.App
 * java -classpath .;std-Maven-0.0.1-SNAPSHOT.jar org.sandrm.studyMaven.App
 * java -cp std-Maven-0.0.1-SNAPSHOT.jar org.sandrm.studyMaven.App
 */
public class App {
    public static void main( String[] args ){
        System.out.println( "Refresh Maven!" );
        
    	Properties prop = new Properties();
    	InputStream input = null;
    	
    	
    	try {
			//input = new FileInputStream("config.properties");
    		//input = App.class.getResourceAsStream("//src//main//resources//config.properties");
    		
    		//Load a properties file from classpath
    		input = App.class.getClassLoader().getResourceAsStream("config.properties");
    		
    		
			prop.load(input);
			
			System.out.println(prop.getProperty("param1"));
			System.out.println(prop.getProperty("param2"));
			
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
