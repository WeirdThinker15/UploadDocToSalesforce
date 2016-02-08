/**
 * 
 */
package com.wt15.sfdc.upload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author weirdThinker15
 * Description		: This Class will read from the config.properties File that contains the various properties required in the Java Code
 * 
 *
 */
public class Configs 
{
	private static String documentRestURL;
	private static String authToken;
	private static String folderId;
	
	public static boolean loadProperties()
	{
		boolean success = true;
		Properties prop = new Properties();
		InputStream is = null;
		try
		{
			is = new FileInputStream("config.properties");
			//Load the Properties File 
			prop.load(is);
			//Set the Properties to the member variables 
			documentRestURL = prop.getProperty("documentRestURL");
			authToken = prop.getProperty("authToken");
			folderId = prop.getProperty("folderId");
		}
		catch (IOException ex) 
		{
			success = false;
		}
		return success;
	}

	public static String getDocumentRestURL() {
		return documentRestURL;
	}

	public static String getAuthToken() {
		return authToken;
	}

	/**
	 * @return the folderId
	 */
	public static String getFolderId() {
		return folderId;
	}
	
	
	
	
}
