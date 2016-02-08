/**
 * 
 */
package com.wt15.sfdc.upload;

import java.io.File;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

/**
 * @author WeirdThinker15
 * Description		: This class takes care of building the Post Request Body 
 *
 */
public class PostRequestBuilder 
{
	private String filetoUpload;
	private EntityDocument docDetails;
	private String boundary;
	private String fileType;
	
	/**
	 * @param filetoUpload
	 * @param docDetails
	 */
	public PostRequestBuilder(String filetoUpload, EntityDocument docDetails) {
		super();
		this.filetoUpload = filetoUpload;
		this.docDetails = docDetails;
		this.boundary = "boundary" + System.currentTimeMillis();
		this.fileType = FileUtil.getFileMimeTypeManual(new File(this.filetoUpload));
	}
	
	/*
	 * Function		: buildRequestBody
	 * Description	: This prepares the Body for the HttpPost 
	 * @returns		: HttpEntity
	 */
	private HttpEntity buildRequestBody()
	{
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		//Set the Boundary String 
		builder.setBoundary(boundary);
		//Set the Mode - This will put the Content-Disposition and Content-Type headers in the request Body
	    builder.setMode(HttpMultipartMode.STRICT);
	    //Add the Non-Binary Part i.e. Details of the Document being uploaded 
	    builder.addTextBody("entity_document",docDetails.prepareJSON(),ContentType.APPLICATION_JSON);
	    //Add the Binary Part i.e. File Contents 
	    File inpFile = new File(filetoUpload);
	    FileBody fb;
	    fb = new FileBody(inpFile,ContentType.create(fileType));
		builder.addPart("Body", fb);
		return builder.build();
		
	}
	
	/*
	 * Function		: preparePostRequest
	 * Description	: This prepares the HttpPost Request 
	 * @returns		: HttpPost
	 */
	public HttpPost preparePostRequest()
	{
		HttpPost hpost = new HttpPost(Configs.getDocumentRestURL());
		// Set the Headers
		// Set Authorization
		hpost.addHeader("Authorization", "Bearer " + Configs.getAuthToken());
		// Set the Content Type
		hpost.addHeader("Content-Type","multipart/form-data;boundary=" + boundary);
		//Set the Request Body
		hpost.setEntity(buildRequestBody());
		return hpost;
		
	}
	
	

}
