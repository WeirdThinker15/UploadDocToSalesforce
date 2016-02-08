/**
 * 
 */
package com.wt15.sfdc.upload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 * @author WeirdThinker15
 * Description	: This Class tries to identify the content type of the file for using in the HttpPost Request 
 * Note : The resultant file types and other details is not accurate and should not be construed as final. 
 */
public class FileUtil 
{
	private static HashMap<String, String> mimeMap = new HashMap<String, String>();
	
	private static void init()
	{
		mimeMap.put("png","image/png");
		mimeMap.put("jpg","image/jpg");
		mimeMap.put("jpeg","image/jpg");
		mimeMap.put("gif","image/gif");
		mimeMap.put("txt","text/plain");
		mimeMap.put("pdf","application/pdf");
		mimeMap.put("json","application/json");
		mimeMap.put("xml","application/xml");
		mimeMap.put("default","application/octet-stream");
	}
	
	public static String getFileMimeType(File f)
	{
		String fileType = "application/octet-stream";
		try {
			fileType = Files.probeContentType(f.toPath());
			System.out.println("Read File Type as " + fileType + " " + f.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			fileType = "unknown";
		}
		return fileType;
	}
	
	public static String getFileMimeTypeManual(File f)
	{
		if(mimeMap.isEmpty())
			init();
		String fileType = "application/octet-stream";
		fileType = FilenameUtils.getExtension(f.getAbsolutePath());
		if(mimeMap.containsKey(fileType))
			fileType = mimeMap.get(fileType);
		else
			fileType = mimeMap.get("default");
		return fileType;
	}

}
