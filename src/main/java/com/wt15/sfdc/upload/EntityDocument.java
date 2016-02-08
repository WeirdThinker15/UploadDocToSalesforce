package com.wt15.sfdc.upload;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author weirdThinker15
 * Description		: This Class will prepare a JSON with key/value pairs indicating the details of document to be uploaded to Salesforce.
 * 
 *
 */
public class EntityDocument 
{
	private String Name;		// Name of the Document 
	private String Description; // Description if any 
	private String FolderId;	// Folder Id to where document will be uploaded 
	private String Type;		// Extension of File or Type of File 
	private String Keywords;
	
	/**
	 * @param name
	 * @param description
	 * @param folderId
	 * @param type
	 * @param keywords
	 */
	public EntityDocument(String name, String description, String folderId,
			String type, String keywords) {
		super();
		Name = name;
		Description = description;
		FolderId = folderId;
		Type = type;
		Keywords = keywords;
	}
	
	/**
	 * @param name
	 * @param folderId
	 * @param type
	 */
	public EntityDocument(String name, String folderId, String type) {
		super();
		Name = name;
		FolderId = folderId;
		Type = type;
	}

	/*
	 * Function		: prepareJSON
	 * Description	: This will prepare a JSON with the given member fields.
	 * Note			: docName,folderId are mandatory, with rest optional. 
	 */
	public String prepareJSON()
	{
		GsonBuilder builder = new GsonBuilder();
		Gson gs = builder.create();
		return gs.toJson(this);
	}
}
