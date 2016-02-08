package com.wt15.sfdc.upload;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

/**
 * Document Upload to SFDC POC
 * @author WeirdThinker15
 * @description  : This POC is to demonstrate uploading of a file(image/doc/pdf) to Salesforce Document Object .
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String response;
    	String filetoUpload;
        if(args.length == 1)
        	filetoUpload = args[0];
        else
        	filetoUpload = "/Users/aditya/Downloads/poc.pdf";
        
        //Load the Properties Files 
        Configs.loadProperties();
        //Create a Entity Document which stores the details of the File 
        EntityDocument entDoc = new EntityDocument("Twitter",Configs.getFolderId(),"png");
        //Prepare the Post Request to be sent 
        PostRequestBuilder req = new PostRequestBuilder(filetoUpload, entDoc);
        try {
			HttpService.uploadDoc(req.preparePostRequest());
			//Read the Response received 
			response = HttpService.readResponse();
			//Convert to SFDCResponse Instance 
			SFDCResponse sr = SFDCResponse.convertResponse(response);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while sending the Post Request : ");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while sending the Post Request : ");
			e.printStackTrace();
		}
        
    }
}
